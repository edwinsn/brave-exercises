(ns brave-exercises.chapter4.steps-to-success
  (:require [brave-exercises.chapter4.lib :as lib])
  )

;An brave ant walks towards his house, 1 meter appart, but she is tired, every new step takes her a ledd of the previous step
;she starts with 1 centimeter then a half, then a third and so on (1 1/3 1/4 1/5 ...), every time slower.
;But she is determined, she will never stop! She will make the necesary steps
;Will she arrive?

;Create a lazy sequence, hey!!! the ant is not lazy, carefull of what you think!


(let [steps (map (fn [x] (/ 1 x)) (iterate inc 1))]
  (let [ total_steps_taken (reduce (fn [[distance_traveled steps_taken] step]
            (if (> distance_traveled 10)
              ;if the ant has any hope we better use reduced to scape from the cycle,
              ; otherwise it will be us the ones who will never arrive to the end of this program
              (reduced steps_taken)
              [(+ distance_traveled step) (inc steps_taken)]
              ))
          [0 0] steps)]
    (println "Man, the ant arrived! It was a long journey"
      {
              :total_steps_taken total_steps_taken
              })
    )
  )

