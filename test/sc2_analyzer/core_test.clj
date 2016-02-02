(ns sc2-analyzer.core-test
  (:require [clojure.test :refer :all]
            [sc2-analyzer.core :refer :all]
            [sc2-analyzer.sc2-wrapper :refer :all]))

(def objects '("{" "fdsfs" "}" "{}" "{" "}"))


(def test-lines
  [" {'_bits': 160,"
   " '_event': 'NNet.Replay.Tracker.SPlayerSetupEvent',"
   " '_eventid': 9,"
   " '_gameloop': 0,"
   " 'm_playerId': 0,"
   " 'm_slotId': None,"
   " 'm_type': 3,"
   " 'm_userId': None}"
   " {'_bits': 192,"
   " '_event': 'NNet.Replay.Tracker.SPlayerSetupEvent',"
   " '_eventid': 9,"
   " '_gameloop': 0,"
   " 'm_playerId': 1,"
   " 'm_slotId': 0,"
   " 'm_type': 1,"
   " 'm_userId': 0}"])

(def for-clean
  ["{'m_cacheHandles': ['s2ma\\x00\\x00USm\\xe4\\x15\\x03\\xba\\xcc\\xd0VV6\\x0bo\\x02}\\xb8\\x81i\\xfa\\x19\\x89\\xbbcW\\xb1\\xb2\\x15\\xa2Ty9\\xf5\\xfb',"
   "'s2ma\\x00\\x00USB\\x1c\\x8a\\xa0\\xf3a\\x9be-#\\xa2s]\\xfe\\xe8\\x12\\xabdB(#^zy~\\xde\\xcf\\xe8\\xb6}\\xa3\\x0e',"
   "'s2ma\\x00\\x00USf\\t82\\x12\\x84S\\xef\\xff\\xbbx|\\x80\\xb7\\xd3\\xee\\xc1\\xad\\x81\\xbd\\xe5\\\\\\x83\\xc90\\xde\\xa7\\x9cNPZ\\x04',"
   "'s2ma\\x00\\x00USW\\xb4\\xac\\x0b=\\xda\\xd0T\\xba\\xdf\\x85\\xa9LfnW\\xe4v\\x9d\\x08x\\xca\\x96r\\x07\\x9e\\xc96\\xb8\\x0b\\x98\\xdc',"
   "'s2ma\\x00\\x00US\\x7fAA\\x1a\\xa5\\x97\\xf4\\xb4d@\\xd4*V3H\\xbfS\\x82-*h\\x11/\\x01\\x04\\xf9\\xb8\\x91\\xf6\\xf0Z\\xe1',"
   "'s2ma\\x00\\x00US\\xfb\\xc9j\\x8d\\xa9u-\\x06\\x04\\x9d\\xda!\\xe2\\x12Y\\x15\\xa7R\\x7f\\xbd9{\\x90\\x07\\xc2\\x8ej\\rO7#q'],"
   "'m_toon': {'m_id': 4263849, 'm_programId': '\\x00\\x00S2', 'm_realm': 1, 'm_region': 1}}"])

(deftest c-test
  (testing "string cleaning"
    (let [req '("{'m_cacheHandles': [''," "''," "''," "''," "''," "'']}")
          res (map strip-special for-clean)]
      (is (= req res)))))


(deftest b-test
  (testing "object separation"
    (let [req '(("{" "fdsfs" "}") ("{}") ("{" "}"))
          res (separate-objects objects)]
      (is (= req res)))))

(deftest a-test
  (testing "FIXME, I fail."
    (let [req '({"_event" "NNet.Replay.Tracker.SPlayerSetupEvent" "_gameloop" 0}
                 {"_event" "NNet.Replay.Tracker.SPlayerSetupEvent" "_gameloop" 0})
          res (json-tracker test-lines)]
      (is (= req res)))))

