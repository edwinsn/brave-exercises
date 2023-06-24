(ns brave-exercises.chapter5.exercise5)

(defn my-update-in [map [key & keys] function ]
  (if keys
    (assoc map key (my-update-in (get map key) keys function) )
    (update map key function)
    )
  )

(def my-map {:a {:b {:c 1}}})

;Simple update
(println (my-update-in my-map [:a :b :c] #(* 2 %)))

;If the value is nil
(println (my-update-in my-map [:a :b :d] #(or % "Default value") ))