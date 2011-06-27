(ns session-counter.core
  (:use
    [clojure.contrib.pprint :only (pprint)]
    net.cgrand.moustache
    [ring.middleware.session :only (wrap-session)]
    [ring.util.response :only (response)]
    [ring.adapter.jetty :only (run-jetty)]))


(defn counter-handler [req]
  (let [session (:session req)
        cnt (inc (session :counter 0))
        res (response (format "You visited %d times:\n\n%s"
                        cnt
                        (with-out-str (pprint req))))]
    (assoc res :session (assoc session :counter cnt))))

(def myapp
  (app
    (wrap-session)
    [""] counter-handler))
