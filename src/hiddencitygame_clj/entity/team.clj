(ns hiddencitygame-clj.entity.team
  (:require [bouncer.core :as b]
            [bouncer.validators :as v]
            ))

(defn validate-message [params]
  (print "Testing")
  (b/validate
    params
    :team-code v/required
    )
  )

(defn generate-team [gcm]
  {
   :type       (str "generate-team")
   :parameters (str gcm)
   }
  )



(defn add-player [gcm team-map]
  (validate-message team-map)
  {
   :type       (str "add-player")
   :parameters (str gcm ";" (get team-map :team-code))
   }
  )

