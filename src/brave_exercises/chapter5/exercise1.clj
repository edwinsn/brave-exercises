(ns brave-exercises.chapter5.exercise1)

;You used (comp :intelligence :attributes) to create a function that returns a character’s intelligence.
;Create a new function, attr, that you can call like (attr :intelligence) and that does the same thing.

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(defn attr [key]
  ((comp key :attributes) character)
  )

(println (attr :intelligence))