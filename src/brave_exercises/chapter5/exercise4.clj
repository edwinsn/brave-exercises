(ns brave-exercises.chapter5.exercise4)

;Look up and use the update-in function
(def my-map {:a {:b {:c 1}}})

;Simple update
(println (update-in my-map [:a :b :c] #(* 2 %)))

;If the value is nil
(println (update-in my-map [:a :b :d] #(or % "Default value") ))

;Pass many additional values to the updater
(println (update-in my-map [:a :b :c] + 1 2 3))