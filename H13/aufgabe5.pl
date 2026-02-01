%Anfrage ?- q(Z, s(0))
q(X, X) :- q(s(X), Y).
q(0, Y) :- h(s(Y), Y).
q(s(X), X).
h(X, X) :- q(s(X), X).
