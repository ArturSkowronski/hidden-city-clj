(ns hiddencitygame-clj.handler
  (:require [compojure.core :refer [defroutes routes wrap-routes]]
            [hiddencitygame-clj.layout :refer [error-page]]
            [hiddencitygame-clj.routes.home :refer [home-routes]]
            [hiddencitygame-clj.routes.view :refer [view-routes]]
            [hiddencitygame-clj.routes.team :refer [register-team-routes join-team-routes]]
            [hiddencitygame-clj.middleware :as middleware]
            [clojure.tools.logging :as log]
            [compojure.route :as route]
            [environ.core :refer [env]]
            [hiddencitygame-clj.config :refer [defaults]]
            [mount.core :as mount]))

(defn init
  "init will be called once when
   app is deployed as a servlet on
   an app server such as Tomcat
   put any initialization code here"
  []
  (when-let [config (:log-config env)]
    (org.apache.log4j.PropertyConfigurator/configure config))
  (doseq [component (:started (mount/start))]
    (log/info component "started"))
  ((:init defaults)))

(defn destroy
  "destroy will be called when your application
   shuts down, put any clean up code here"
  []
  (log/info "hiddencitygame-clj is shutting down...")
  (doseq [component (:stopped (mount/stop))]
    (log/info component "stopped"))
  (log/info "shutdown complete!"))

(def app-routes
  (routes
    (wrap-routes #'home-routes middleware/wrap-csrf)
    (wrap-routes #'view-routes middleware/wrap-csrf)
    (wrap-routes #'register-team-routes middleware/wrap-formats)
    (wrap-routes #'join-team-routes middleware/wrap-formats)
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))

(def app (middleware/wrap-base #'app-routes))
