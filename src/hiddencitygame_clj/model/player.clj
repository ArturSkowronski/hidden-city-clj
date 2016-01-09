(ns hiddencitygame-clj.model.player
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [monger.json])
  (:import [org.bson.types ObjectId])
  )

(def conn (mg/connect {:host "localhost"}))
(def db (mg/get-db conn "hidden-city-game"))
(def players-coll "players")

(defn store-player [player]
  (mc/insert-and-return db players-coll {
                                         :_id (ObjectId.)
                                         :gcm (get player :gcm)
                                         :role (get player :role)
                                         }))