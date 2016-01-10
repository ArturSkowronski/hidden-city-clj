(ns hiddencitygame-clj.model.places
  (:require [monger.collection :as mc]
            [monger.core :as mg])
  (:import (org.bson.types ObjectId)))

(def conn (mg/connect {:host "localhost"}))
(def db (mg/get-db conn "hidden-city-game"))
(def places-coll "places")

(defn find-start []
  (mc/find-one db places-coll {:isStart true}))
