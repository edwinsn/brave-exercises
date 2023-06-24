(ns brave-exercises.chapter7.exercise2-alternative-solution)

;Create an infix function that takes a list like (1 + 3 * 4 - 5)
;and transforms it into the lists that Clojure needs in order to correctly evaluate the expression
;using operator precedence rules.
; !!!WARNING this macro is not working yet, it is on the repo to save the progress.


(defn last-op-index [expr]
  (let [precedence {'+ 1, '- 1, '* 2, '/ 2}]
    (first (reduce (fn [[min-idx min-pre] [idx token]]
                     (if (and (contains? precedence token)
                              (<= (precedence token) min-pre))
                       [idx (precedence token)]
                       [min-idx min-pre]))
                   [nil ##Inf]
                   (map-indexed vector expr)))))


(defn check-if-is-number-or-infixed-list [operand]
  (if (= 1 (count operand))
    (first operand)
    operand))
(defmacro infix [infixed]
  (let [
        operator-index (last-op-index infixed)
        operator (nth infixed operator-index)
        left-operand-infixed (take operator-index infixed)
        right-operand-infixed (drop (inc operator-index) infixed)
        left-operand (check-if-is-number-or-infixed-list left-operand-infixed)
        right-operand (check-if-is-number-or-infixed-list right-operand-infixed)
        ]
    (let  [result `((quote ~operator)
                    ~(if (number? left-operand) left-operand `(infix ~left-operand))
                    ~(if (number? right-operand) right-operand `(infix ~right-operand))
                    )]
      result
      )
    )
  )

(infix (1 + 3 * 4 - 7))