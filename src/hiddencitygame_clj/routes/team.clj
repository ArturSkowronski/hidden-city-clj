(ns hiddencitygame-clj.routes.team
  (:require [hiddencitygame-clj.layout :as layout]
            [hiddencitygame-clj.entity.team :as team]
            [hiddencitygame-clj.responses.errors :as response-errors]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            )
  )

(def register-team-request {:gcm nil})
(def join-team-request {:gcm nil :code nil})

(defn validate-join-team [params]
  (first
  (b/validate params
              :gcm v/required
              :code v/required
              )
  )
)

(defn validate-register-team [params]
  (first
    (b/validate params
              :gcm v/required
              )
  )
  )

(defroutes register-team-routes
           (POST "/registerTeam" []
             (fn [req]
               (if-let [errors (validate-register-team (:params req))]
                 (response-errors/validation-error errors)
                 (do
                   (let [
                         gcm (get (:params req) :gcm)
                         ]
                     {
                      :status  200
                      :headers {"Content-Type" "application/json"}
                      :body    (team/generate-team gcm)
                      }
                     )
                   )

                 )
               )
             )
           )


(defroutes join-team-routes
           (POST "/joinTeam" []
             (fn [req]
               (if-let [errors (validate-join-team (:params req))]
                 (response-errors/validation-error errors)
                 (do
                   (let [
                         gcm (get (:params req) :gcm)
                         code (get (:params req) :code)
                         ]
                     {
                      :status  200
                      :headers {"Content-Type" "application/json"}
                      :body    (team/add-player gcm {:team-code code})
                      })
                   )
                 )
               )
             ))