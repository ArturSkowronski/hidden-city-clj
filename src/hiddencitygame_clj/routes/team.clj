(ns hiddencitygame-clj.routes.team
  (:require [hiddencitygame-clj.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]
            [bouncer.core :as b]
            [bouncer.validators :as v]
  )
  )

(defroutes register-team-routes
   (POST "/registerTeam" []
     (fn [req]
       (let [
             gcm (get (:params req) "gcm")
            ]
         {
          :status  200
          :headers {"Content-Type" "application/json"}
          :body    {:foo (str "registerTeam:" gcm)}
          }
       )
     )
   )
)

(defn validate-message [params]
  (first
    (b/validate
      params
      :gcm v/required
    )
  )
)

(defroutes join-team-routes
 (POST "/joinTeam" []
   (fn [req]
     (let [
           gcm (get (:params req) "gcm")
           code (get (:params req) "code")
          ]
       {
        :status  200
        :headers {"Content-Type" "application/json"}
        :body    {:foo (str "joinTeam:" gcm ":" code)}
        })
     )
   )
 )
