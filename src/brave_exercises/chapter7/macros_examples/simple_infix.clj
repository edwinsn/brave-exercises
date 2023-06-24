(ns brave-exercises.chapter7.simple-infix)

(defmacro infix
  "Use this macro when you pine for the notation of your childhood"
  [infixed]
  (list (second infixed) (first infixed) (last infixed)))

(infix (1 + 1))

(macroexpand '(infix (1 + 1)))

(macroexpand (+ 1 2))

(macroexpand `(if true 1 2))

(conj `(12 1) 3 4)

'(+ 1 1)

(defmacro my-print
  [expression]
  (list 'let ['result expression]
        (list 'println 'result)
        'result)
  )

(my-print "Hola")

(println "Hola")