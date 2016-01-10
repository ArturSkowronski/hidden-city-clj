(ns hiddencitygame-clj.entity.player
  (:require [bouncer.core :as b]
            [hiddencitygame-clj.entity.role :as role]
            [hiddencitygame-clj.model.player :as player-model]
            [bouncer.validators :as v]
            )
  )

(defn create-player
  "create-player"
  [params]
  (player-model/store-player params)
  )

(defn create-game-master
  "Create Game Master"
  [params]
  (def stored-model (create-player {
                   :gcm  (get params :gcm)
                   :role (role/findRandomRole)
                   }))
  stored-model
  )

