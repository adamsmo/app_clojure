(defproject sc2_analyzer "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha3"]
                 [org.clojure/data.json "0.2.6"]
                 [clj-time "0.11.0"]
                 [iota "1.1.3"]]
  :main ^:skip-aot sc2-analyzer.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
