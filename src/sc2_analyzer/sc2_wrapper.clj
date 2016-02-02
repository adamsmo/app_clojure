(ns sc2-analyzer.sc2-wrapper
  (:require [clojure.data.json :as json])
  (:require [clojure.string :as string]))


(defn extract [s] (filter #(or (= \{ %) (= \} %)) (seq s)))

(defn process-braces
  [stack braces]
  (reduce (fn [first second]
            (if (= second \{)
              (conj first second)
              (pop first)))
          stack
          braces))

(defn separator
  [stack lines]
  (let [[first & rest] lines
         nstack (process-braces stack (extract first))]
    (if (empty? nstack)
      (list first)
      (concat (list first) (separator nstack rest)))))

(defn separate-objects
  [lines]
  (lazy-seq
    (when (not (empty? lines))
      (let [object (separator '() lines)]
        (cons object (separate-objects (drop (count object) lines)))))))


;(require '[sc2-analyzer.sc2-wrapper :as sc])

(defn strip-special [text]
  (string/replace text #"\\.*('|\")" "'"))

(defn fix-json [text]
  (let [formated (string/replace text #"'|None|False|True" {"'" "\"", "None" "null", "False" "false", "True" "true"})]
    (string/replace formated #"\s" " ")))

(defn filter-details [json]
  (map-indexed (fn [idx obj] (assoc (select-keys obj ["m_race" "m_name" "m_result"]) "m_playerId" (+ 1 idx)))
               (get json "m_playerList")))

(defn filter-tracker [json]
  ;(select-keys json ["_event" "_gameloop" "m_unitTypeName" "m_controlPlayerId" "m_unitTagIndex" "m_unitTagRecycle"])
  json
  )


(defn to-json [fileLines]
  (->> fileLines (map strip-special) separate-objects (map string/join) (map fix-json) (map json/read-str)))


(defn json-details [fileLines] (flatten (map filter-details (to-json fileLines))))

(defn json-tracker [fileLines] (map filter-tracker (to-json fileLines)))

