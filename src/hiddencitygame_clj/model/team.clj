(ns hiddencitygame-clj.model.team
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import (org.bson.types ObjectId)
           (com.mongodb WriteConcern)))

(def conn (mg/connect {:host "localhost"}))
(def db (mg/get-db conn "hidden-city-game"))
(def teams-coll "teams")

(defn store-team [team]
  (mc/insert-and-return db teams-coll {
                                       :_id  (ObjectId.)
                                       :teamCode (get team :team-code)
                                       :players (get team :players)
                                       :currPlace (get team :start-place)
                                       })
)

(defn find-one [params]
    (mc/find db teams-coll params)
)

(defn add-player [match player]
  (mc/update db teams-coll match {"$push" {:players player}})
)