(ns hiddencitygame-clj.entity.view
  (:require [clojure.java.io :as io])
  (:import (com.github.jknack.handlebars Handlebars Template)
))


(defn read-template
  "Read HBS Template"
  [name]
  (slurp
    (io/file
    (io/resource
      (str "hbs/" name ".hbs")))
    )
  )

(defn render-view
  "Stub Method"
  [params]
  (let [hbs (Handlebars.)]
   (.apply (.compileInline hbs (read-template (get params :tpl))) {"id" "test"})
  )
)
