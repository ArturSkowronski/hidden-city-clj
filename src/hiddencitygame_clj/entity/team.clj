(ns hiddencitygame-clj.entity.team)

(defn generate-team [gcm]
   {:foo (str "decorated1:" gcm)}
)

(defn add-player [gcm team-map]
   {:foo (str "decorated1:" gcm (get team-map :team-code))}
)