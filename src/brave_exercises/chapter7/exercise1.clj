(ns brave-exercises.chapter7.exercise1)

;Use the list function, quoting, and read-string to create a list that,
;when evaluated, prints your first name and your favorite sci-fi movie.

;I could also use read-string in "Edwin" and "Xataca" but the evaluator would resolve them to strings anyway,
; So it is not necessary
(eval (list (read-string "println") "Name: Edwin\n" "Sci-fi movie: Xataca"))