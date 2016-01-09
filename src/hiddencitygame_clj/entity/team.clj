(ns hiddencitygame-clj.entity.team
  (:require [bouncer.core :as b]
            [bouncer.validators :as v]
            [hiddencitygame-clj.entity.player :as player]
            ))

(defn validate-message [params]
  (print "Testing")
  (b/validate
    params
    :team-code v/required
    )
  )

(defn generate-team [gcm]
  "Generate New Team"
  {
   :type         (str "generate-team")
   :parameters   (str gcm)
   :saved-record (get (player/create-game-master {:gcm gcm}) :_id)
   }
  )

(defn add-player [gcm team-map]
  (validate-message team-map)
  {
   :type       (str "add-player")
   :parameters (str gcm ";" (get team-map :team-code))
   }
  )



