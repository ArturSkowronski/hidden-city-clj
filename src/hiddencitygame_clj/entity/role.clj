(ns hiddencitygame-clj.entity.role)

(def roles [:role1 :role2 :role3 :role4])

(defn findRandomRole
  "Find Role for Game Master"
  []
  (rand-nth roles)
)
