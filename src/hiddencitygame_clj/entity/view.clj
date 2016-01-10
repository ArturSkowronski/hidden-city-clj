(ns hiddencitygame-clj.entity.view
  (:require [clojure.java.io :as io]
            [hiddencitygame-clj.handlebars :as hbs])
)

(defn render-view
  "Render View Method"
  [data]
  (hbs/render-view data)
)
