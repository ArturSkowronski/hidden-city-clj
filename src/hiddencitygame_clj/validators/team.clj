(ns hiddencitygame-clj.validators.team
  (:require [bouncer.core :as b]
            [bouncer.validators :as v]
            ))

(defn join-team [params]
  (first
    (b/validate params
                :gcm v/required
                :code v/required
                )
    )
  )

(defn register-team [params]
  (first
    (b/validate params
                :gcm v/required
                )
    )
  )
