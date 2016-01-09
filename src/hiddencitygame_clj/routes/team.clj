(ns hiddencitygame-clj.routes.team
  (:require [hiddencitygame-clj.entity.team :as team]
            [hiddencitygame-clj.responses.errors :as resp]
            [hiddencitygame-clj.validators.team :as valid]

            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            )
  )

(defroutes register-team-routes
           (POST "/registerTeam" []
             (fn [req]
               (if-let [errors (valid/register-team (:params req))]
                 (resp/validation-error errors)
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
               (if-let [errors (valid/join-team (:params req))]
                 (resp/validation-error errors)
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