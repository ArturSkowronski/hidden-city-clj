(ns hiddencitygame-clj.entity.player
  (:require [bouncer.core :as b]
            [hiddencitygame-clj.entity.role :as role]
            [hiddencitygame-clj.model.player :as player-model]
            [bouncer.validators :as v]
            )
  )

(defn createGameMaster
  "Create Game Master"
  [params]
  (let [
        :gcm-req (get params :gcm)
        ]

    (player-model/store-player {
                                :gcm :gcm-req
                                :role (role/findRandomRole)
                                })
    )
  )