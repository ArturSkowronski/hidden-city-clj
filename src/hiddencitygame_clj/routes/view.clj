(ns hiddencitygame-clj.routes.view
  (:require [hiddencitygame-clj.entity.view :as view]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]))

(defroutes view-routes
   (GET "/view/:id" [id] []

        {
        :status 200
        :headers {"Content-Type" "application/json"}
        :body {:tpl (view/render-view {:tpl "test" :params {"id" id}}) }
        }
   )
)
