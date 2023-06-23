(ns brave-exercises.chapter4.exercise4
  (:require [brave-exercises.chapter4.lib :as lib])
  )

;Write a function that will take your list of maps and convert it back to a CSV string.
;You’ll need to use the clojure.string/join function
(def filename "suspects.csv")
(let [
      suspects (lib/filter-suspects-from-file filename) 
      suspects-CSV-string (reduce #(str % (:name %2) "," (:glitter-index %2) "\n") "" suspects)
      ]
  (println suspects-CSV-string)
  )