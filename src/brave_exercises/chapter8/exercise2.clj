(ns brave-exercises.chapter8.exercise2)

; Implement or as a macro
(defmacro my-or
  "Takes any number of arguments and returns the first truthy value.
   If none of the arguments are truthy, it returns nil"
  ([] nil)
  ([x] (if x x nil))
  ([x & next]
   `(let [or# ~x]
      (if or# or# (my-or ~@next) ))))


(my-or)
(my-or "false" true )
(my-or false true )
(my-or nil false)