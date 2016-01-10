(ns hiddencitygame-clj.entity.team
  (:require [bouncer.core :as b]
            [bouncer.validators :as v]
            [hiddencitygame-clj.entity.player :as player]
            [hiddencitygame-clj.model.team :as model]
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
  (rand-int 9999)
)

(defn store-team-with-code
  "Store Team for code"
  [player]
  (try
    (model/store-team {
                       :team-code (generate-team-code)
                       :players   [player]
                       })
    (catch Exception e
      (store-team-with-code player)))
  )


(defn generate-team [gcm]
  "Generate New Team"
  (def saved-team (store-team-with-code (player/create-game-master {:gcm gcm})))
  {
   :type         (str "generate-team")
   :parameters   (str gcm)
   :saved-record (get  saved-team :_id)
   }
)

(defn add-player [gcm team-map]
  (validate-message team-map)
  {
   :type       (str "add-player")
   :parameters (str gcm ";" (get team-map :team-code))
   }
  )

(defn add-player [gcm team-map]
  (validate-message team-map)
  {
   :type       (str "add-player")
   :parameters (str gcm ";" (get team-map :team-code))
   }
  )



