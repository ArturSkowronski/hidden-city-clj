(ns hiddencitygame-clj.entity.team
  (:require [bouncer.core :as b]
            [bouncer.validators :as v]
            [hiddencitygame-clj.entity.player :as player]
            [hiddencitygame-clj.model.team :as model-team]
            [hiddencitygame-clj.entity.place :as places]
            ))

(defn validate-message [params]
  (print "Testing")
  (b/validate
    params
    :team-code v/required
    )
  )

(defn generate-team-code
  "Generating new Team Code"
  []
  (+ 1000 (rand-int 8999))
  )

(defn find-by-player-id
  "Find Team By Player ID"
  [player-id]
  (model-team/find-one {:players {"$in" [player-id]}})
  )

(defn add-player-to-team
  "Add Player to Team"
  [team-code player]
  (model-team/add-player {:teamCode team-code} player)
  )


(defn store-team-with-code
  "Store Team for code"
  [params]
  (try
    (model-team/store-team {
                            :team-code   (generate-team-code)
                            :players     [(get params :player)]
                            :start-place [(get params :start-place)]
                            })
    (catch Exception e
      (store-team-with-code params)))
  )

(defn generate-team [gcm]
  "Generate New Team"

  (def saved-team (store-team-with-code {
                                         :start-place (places/find-start)
                                         :player      (player/create-game-master {:gcm gcm})
                                         }))
  {
   :type         (str "generate-team")
   :parameters   (str gcm)
   :saved-record (get saved-team :_id)
   }
)

(defn add-player [gcm params]
  (let [team-code (get params :team-code)]

    (add-player-to-team team-code (player/create-player {:gcm gcm}))
    {
     :type       (str "add-player")
     :parameters (str gcm ";" team-code)
     })
  )


