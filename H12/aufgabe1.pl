hatRang(jgi, professor).
hatRang(mlr, assistent).
hatRang(jck, assistent).
hatRang(nlo, assistent).
hatRang(eme, assistent).
hatRang(jkr, hiwi).
hatRang(jwi, hiwi).
hatRang(gen, student).
hatRang(sma, student).
hatRang(tol, student).
bossVon(X,Y) :- hatRang(X, professor), hatRang(Y, assistent).
bossVon(X,Y) :- hatRang(X, assistent), hatRang(Y, hiwi).
bossVon(X,Y) :- hatRang(X, hiwi), hatRang(Y, student).

hatGleichenRang(X,Y) :- bossVon(X, A), bossVon(Y,A).

vorgesetzt
