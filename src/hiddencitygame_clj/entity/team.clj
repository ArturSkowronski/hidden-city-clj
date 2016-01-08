(ns hiddencitygame-clj.entity.team
  (:require [bouncer.core :as b]))

(defn generate-team [gcm]
   {:foo (str "decorated1:" gcm)}
)

(defn add-player [gcm team-map]
   {:foo (str "decorated1:" gcm (get team-map :team-code))}
)


(defn validate-message [params]
  (first
    (b/validate
      params
      :gcm v/required
      )
    )
  )