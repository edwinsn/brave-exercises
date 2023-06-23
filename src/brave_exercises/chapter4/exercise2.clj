(ns brave-exercises.chapter4.exercise2
  (:require [brave-exercises.chapter4.lib :as lib])
  )

;EXercise: Write a function, append, which will append a new suspect to your list of suspects
(def filename "suspects.csv")


;First solution
;pass the suspects list and the new suspect

(defn append [item list_of_items ]
  (into list_of_items [item] )
  )

(let [list-of-suspects (lib/filter-suspects-from-file filename)
      new-suspect (lib/validate-suspect {:name "Jordan" :glitter-index 8})
      ]
  (print (append new-suspect list-of-suspects))
)

;Second solution
;Only pass the suspect

;(def list_of_suspects (lib/filter-suspects-from-file filename) )
;(def append (partial conj list_of_suspects))
;(print (append  (lib/validate-suspect {:name "Jordan" :glitter-index 8}) ))