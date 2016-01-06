(ns hiddencitygame-clj.config
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[hiddencitygame-clj started successfully]=-"))
   :middleware identity})
