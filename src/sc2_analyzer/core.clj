(ns sc2-analyzer.core
  (:gen-class)
  (:require [sc2-analyzer.tools :refer :all])
  (:require [clojure.string :as string]))

(defn -main
  "I don't do a whole lot ... yet."
  [filename & args]
  (println (string/join "\n" (process-SC2-players-data filename))))