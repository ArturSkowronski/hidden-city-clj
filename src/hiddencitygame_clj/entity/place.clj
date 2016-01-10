(ns hiddencitygame-clj.entity.place
  (
    :require [hiddencitygame-clj.model.places :as model]
  )
)

(defn find-start
  "Find Start Place"
  []
  (model/find-start)
  )