(ns brave-exercises.chapter5.exercise2)


;Implement the comp function.
(defn mycomp [& functions]
  (fn [args]
    (reduce (fn [acc f]
              (f acc)
              )
            args
            (reverse functions))
    )
  )

(def oddIncrement (mycomp inc #(* 2 %) ))
(println (oddIncrement 1))
(println (oddIncrement 11))

