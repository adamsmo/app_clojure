(ns sc2-analyzer.core-test
  (:require [clojure.test :refer :all]
            [sc2-analyzer.core :refer :all]
            [sc2-analyzer.sc2-wrapper :refer :all]
            [sc2-analyzer.test-data :refer :all]))

(def objects '("{" "fdsfs" "}" "{}" "{" "}" "{" "{" "}}"))

(deftest utf-clean
  (testing "string cleaning"
    (let [req cleaned-data
          res (map strip-special for-clean)]
      (is (= req res)))))

(deftest json-parsing
  (testing "object separation"
    (let [req [["{" "fdsfs" "}"] ["{}"] ["{" "}"] ["{" "{" "}}"]]
          res (separate-objects objects)]
      (is (= req res))))
  (testing "object deserialization"
    (let [req example-json-details
          res (to-json example-details)]
      (is (= req res)))))

(deftest get-player-details
  (testing "player data extraction"
    (let [req expected-players-details
          res (filter-details example-json-details)]
      (is (= req res)))))
