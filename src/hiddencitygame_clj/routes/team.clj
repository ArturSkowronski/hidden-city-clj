(ns hiddencitygame-clj.routes.team
  (:require [hiddencitygame-clj.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io])
  )

(defroutes register-team-routes
   (POST "/registerTeam" []
     (fn [req]
       (let [
             data (get (:params req) "data")
            ]
         {
          :status  200
          :headers {"Content-Type" "application/json"}
          :body    {:foo (str "registerTeam:" data)}
          }
       )
     )
   )
)

(defroutes join-team-routes
 (POST "/joinTeam" []
   (fn [req]
     (let [
           data (get (:params req) "data")
           ]
       {
        :status  200
        :headers {"Content-Type" "application/json"}
        :body    {:foo (str "joinTeam:" data)}
        }
       )
     )
   )
 )
