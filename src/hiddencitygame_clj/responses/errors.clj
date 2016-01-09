(ns hiddencitygame-clj.responses.errors)


(defn validation-error [errors]
  {
   :status  400
   :headers {"Content-Type" "application/json"}
   :body    {:error errors}
   }
  )