(ns brave-exercises.chapter4.exercise1
  (:require [brave-exercises.chapter4.lib :as lib])
  )

;Turn the result of your glitter filter into a list of names
(def filename "suspects.csv")
(let [suspect-names (lib/filter-suspects-from-file filename) ]
  (print (map #(str "'" (:name %) "'") suspect-names))
  )