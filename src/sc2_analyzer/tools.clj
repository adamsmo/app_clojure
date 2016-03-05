(ns sc2-analyzer.tools
  (:require [clojure.string :as string])
  (:require [sc2-analyzer.sc2-wrapper :refer :all])
  (:require [sc2-analyzer.sc2-cons :refer :all])
  (:require [clojure.java.shell :as shell]))


(defn extract-tracker-events [filename]
  (string/split (:out (shell/sh "python" "/Users/adam/Desktop/scalac/s2protocol/s2protocol.py"
                                "--trackerevents" filename)) #"\n"))

(defn extract-initdata [filename]
  (string/split (:out (shell/sh "python" "/Users/adam/Desktop/scalac/s2protocol/s2protocol.py"
                                "--details" filename)) #"\n"))

(defn process-SC2-players-data [filename]
  (json-details (extract-initdata filename)))

(defn process-SC2-events [filename]
  (json-tracker (extract-tracker-events filename)))

(defn convert-to-ms
  "there is 16 gameloops in 1 in game second -> http://us.battle.net/sc2/en/forum/topic/7004015250#2"
  [gameLoop]
  (let [totalseconds (/ gameLoop 16.0)]
    {:minutes (int (/ totalseconds 60.0)) :seconds (mod (int totalseconds) 60)}))

(defn players-upgrades
  [tracker-events]
  (filter
    #(and (= (get % "_event") "NNet.Replay.Tracker.SUpgradeEvent")
          (not= (get % "_gameloop") 0))
    tracker-events))

(defn events-to-seconds
  [tracker-events]
  (map #(assoc % "time" (convert-to-ms (get % "_gameloop")))
       tracker-events))


;(require '[sc2-analyzer.tools :as sc])

(def directory "november_sc2/")


(defn pre-process-units [coll]
  (set (map #(string/upper-case (string/replace % #" " "")) coll)))


(defn filter-events
  [tracker-events pattern]
  (filter
    #(re-find pattern (get % "_event"))
    tracker-events))


(defn filter-workers [te]
  (filter #(when-let [name (get % "m_unitTypeName")] (contains? (set workers) name)) te))


(defn filter-buildings [te]
  (filter #(when-let [name (get % "m_unitTypeName")]
            (contains? (pre-process-units (concat zerg-buildings protoss-buildings terran-buoldings))
                       (string/upper-case name)))
          te))

(defn fill-pid
  [x]
  (let [player-id (reduce #(if (get %2 "m_controlPlayerId") (get %2 "m_controlPlayerId") %1) nil x)]
    (map #(assoc % "m_controlPlayerId" player-id) x)))

(defn collaps-events
  [e1 e2]
  (if (contains? e1 (get e2 "m_unitTypeName")) e1 (assoc e1 (get e2 "m_unitTypeName") e2)))

(defn buildings-timing [te-grouped]
  (let [by-gameloop #(get % "_gameloop")
        coll (map fill-pid (map (fn [x] (sort-by by-gameloop (second x))) te-grouped))
        reduced-coll (map (fn [x] (reduce collaps-events {} x)) coll)
        sorted-coll (sort-by by-gameloop (flatten (map #(vals %) reduced-coll)))
        processed (map #(select-keys % ["_gameloop" "time" "m_unitTypeName" "m_controlPlayerId" "_event"]) sorted-coll)]
    (filter-buildings processed)))


(defn group-by-tag [te]
  (filter #(not= (first %) [nil nil])
          (group-by #(let [unit (get % "m_unitTagIndex")
                           unit_rec (get % "m_unitTagRecycle")]
                      [unit unit_rec])
                    te)))

(defn by-player
  [te]
  (group-by #(get % "m_controlPlayerId") te))

(defn get-workers
  [te]
  (by-player (map #(select-keys % '("_gameloop" "time" "m_unitTypeName" "m_controlPlayerId"))
                  (sort-by #(get % "_gameloop")
                           (filter-workers (filter-events te #"SUnitBornEvent"))))))

(def fs (let [fns [
                   "ZvP - Dominated.SC2Replay"
                   ;"ZvP - Double golde expo.SC2Replay"
                   ;"ZvT -Resilient terran.SC2Replay"
                   ;"ZvP - Muta spine.SC2Replay"
                   ;"ZvZ - logn zvz .SC2Replay"
                   ;"PvP - No idea what Im doing.SC2Replay"
                   ;"PvP - Protossing a Protoss with Protoss units because Prootss (blink stalker).SC2Replay"
                   ]]
          (map (fn [e] (str directory e)) fns)))

; function for quick run in repl
(def test-process
  (map (fn [f]
         (let [te (events-to-seconds (process-SC2-events f))
               det (process-SC2-players-data f)
               upgrades (group-by #(get % "m_playerId") (players-upgrades te))
               buildings (by-player (buildings-timing (group-by-tag te)))
               workers (get-workers te)]
           (map (fn [x]
                  (let [id (get x "m_playerId")
                        race (get x "m_race")
                        name (get x "m_name")
                        selected (map #(select-keys % '("m_unitTypeName" "time" "_gameloop" "m_upgradeTypeName"))
                                      (concat (get workers id) (get buildings id) (get upgrades id)))
                        build-order (sort-by #(get % "_gameloop") selected)]
                    {:name name :race race :order build-order}))
                det)
           )
         ) fs))

