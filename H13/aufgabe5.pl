%Anfrage ?- q(Z, s(0))
q(s(X), X).
q(X, X) :- q(s(X), Y).
q(0, Y) :- h(s(Y), Y).
h(X, X) :- q(s(X), X).
