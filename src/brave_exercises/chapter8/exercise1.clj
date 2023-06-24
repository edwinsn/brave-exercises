(ns brave-exercises.chapter8.exercise1)

;Write the macro when-valid so that it behaves similarly to when. Here is an example of calling it:
;
;(when-valid order-details order-details-validations
;            (println "It's a success!")
;            (render :success))

;Solution
(defmacro when-valid [data validations & body]
  `(when (every? true? (~validations ~data))
     ~@body))

;Examples of how to use
(defn render [event] (get {:success "Rendering awesome UI"} event "Aw, error."))
(def order-details {:item "book" :quantity 2 :price 20.0})
(def invalid-order-details {:item "book" :quantity -2 :price 20.0})


(defn order-details-validations [order]
  [(not (nil? (:item order)))
   (pos? (:quantity order))
   (pos? (:price order))])

(when-valid order-details order-details-validations
            (println "It's a success!")
            (render :success))

(when-valid invalid-order-details order-details-validations
            (println "It's a success!")
            (render :error))