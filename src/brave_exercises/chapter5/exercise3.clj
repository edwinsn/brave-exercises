(ns brave-exercises.chapter5.exercise3)

;Implement the assoc-in function.
;Hint: use the assoc function and define its parameters as [m [k & ks] v]

(defn my-assoc-in [m [k & ks] v]
  (if ks
    (assoc m k (my-assoc-in (get m k) ks v))
    (assoc m k v)
    )
  )

(def my-map1 {:a {:b {:c 1}}})
(println (my-assoc-in my-map1 [:a :b :c] 2))

(def my-map2 {:a {:b {}}})
(println (my-assoc-in my-map2 [:a :b :c] 3))

(def my-map3 {})
(println (my-assoc-in my-map2 [:a :b :c] 4))