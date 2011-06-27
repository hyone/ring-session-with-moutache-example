(defproject session-counter "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [net.cgrand/moustache "1.0.0"]
                 [ring "0.3.8"]]
  :dev-dependencies [[swank-clojure "1.3.0"]
                     [lein-ring "0.4.0"]]
  :ring { :handler session-counter.core/myapp })
