(ns sc2-analyzer.tools
  (:require [clojure.string :as string])
  (:require [sc2-analyzer.sc2-wrapper :refer :all])
  (:require [sc2-analyzer.sc2-cons :refer :all])
  (:require [clojure.java.shell :as shell]))

;(require '[clojure.string :as string])
;(require '[sc2-analyzer.sc2-wrapper :refer :all])
;(require '[sc2-analyzer.sc2-cons :refer :all])
;(require '[clojure.java.shell :as shell])

(defn extract-tracker-events [filename]
  (string/split (:out (shell/sh "python" "/Users/adam/Desktop/s2protocol/s2protocol.py"
                                "--trackerevents" filename)) #"\n"))

(defn extract-initdata [filename]
  (string/split (:out (shell/sh "python" "/Users/adam/Desktop/s2protocol/s2protocol.py"
                                "--details" filename)) #"\n"))

(defn process-SC2-players-data [filename]
  (json-details (extract-initdata filename)))

(defn process-SC2-events [filename]
  (json-tracker (extract-tracker-events filename)))

(defn convert-to-ms
  "there is 16 gameloops in 1 and faster game mode counts 1.425 seconds - synced with lotv.spawningtool.com, possible to be 1s off"
  [gameLoop]
  (let [totalseconds (/ gameLoop (* 1.425 16.0) )]
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

(defn by-gameloop [obj] (obj "_gameloop"))


(defn buildings-timing [te-grouped]
  (->> te-grouped
       ((fn [te] map fill-pid (map #(sort-by by-gameloop (second %)) te)))
       (map (fn [x] (reduce collaps-events {} x)))
       ((fn [rcol] (sort-by by-gameloop (flatten (map #(vals %) rcol)))))
       (map #(select-keys % ["_gameloop" "time" "m_unitTypeName" "m_controlPlayerId" "_event"]))
       (filter-buildings)))


(defn group-by-tag [te]
  (filter #(not= (first %) [nil nil])
          (group-by #(let [unit (% "m_unitTagIndex")
                           unit_rec (% "m_unitTagRecycle")]
                      [unit unit_rec])
                    te)))

(defn by-player
  [te]
  (dissoc (group-by #(% "m_controlPlayerId") te) nil))

(defn get-workers
  [te]
  (by-player (map #(select-keys % '("_gameloop" "time" "m_unitTypeName" "m_controlPlayerId"))
                  (sort-by by-gameloop
                           (filter-workers (filter-events te #"SUnitBornEvent"))))))

;"replays/Dayshi v Nerchio- Game 5 - Ulrena.SC2Replay"

(def directory "replays/")

(def fs (let [fns [
                   "Dayshi v Nerchio- Game 5 - Ulrena.SC2Replay"
                   ;"Lilbow v MarineLorD- Game 2 - Ulrena.SC2Replay"
                   ]]
          (map (fn [e] (str directory e)) fns)))

; mresult -> first is winner

(defn test-process
  []
  (map (fn [f]
         (let [te (events-to-seconds (process-SC2-events f))
               det (process-SC2-players-data f)
               upgrades (group-by #(get % "m_playerId") (players-upgrades te))
               buildings (by-player (buildings-timing (group-by-tag te)))
               workers (get-workers te)]
           (map (fn [x]
                  (let [id (x "m_playerId")
                        race (x "m_race")
                        name (x "m_name")
                        win (= (x "m_result") 1)
                        selected (map #(select-keys % ["m_unitTypeName" "time" "_gameloop" "m_upgradeTypeName"])
                                      (concat (workers id) (buildings id) (upgrades id)))
                        build-order (sort-by #(% "_gameloop") selected)]
                    {:name name :winner win :race race :order build-order}))
                det)
           )
         ) fs))