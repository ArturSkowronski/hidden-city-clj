(ns hiddencitygame-clj.routes.team
  (:require [hiddencitygame-clj.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io])
)

(defroutes register-team-routes
    (POST "/registerTeam" []
       {
        :status 200
        :headers {"Content-Type" "application/json"}
        :body {:foo (str "OK") }
        }
       )
)

(defroutes join-team-routes
   (POST "/joinTeam" []
       {
        :status 200
        :headers {"Content-Type" "application/json"}
        :body {:foo (str "OK") }
        }
   )
)

