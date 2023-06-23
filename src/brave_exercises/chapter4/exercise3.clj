(ns brave-exercises.chapter4.exercise3
  (:require [brave-exercises.chapter4.lib :as lib])
  )

;Write a function, validate, which will check that :name and :glitter-index are present when you append.
;The validate function should accept two arguments: a map of keywords to validating functions,
;similar to conversions, and the record to be validated.

(defn every [condition arr]
  (not (some (complement condition) arr ) )
  )

(defn validate [keys record]
  (every #(contains? record %) keys)
  )

(print (validate [:a :b] {:a "1" :b "2"} ) "\n")

(print (validate [:a :b] {:a "1"} ) "\n")

(print (validate [:a :b] {:a "1" :c "3"} ))