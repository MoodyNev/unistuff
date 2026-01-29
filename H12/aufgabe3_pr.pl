%alle Namen aus der Liste Personen
person(jgi).
person(mlr).
person(jck).
person(nlo).
person(eme).
person(jkr).
person(jwi).
person(gen).
person(sma).
person(tol).
%alle Ränge, die den Personen zugeordnet worden sind
hatRang(jgi,professor).
hatRang(mlr,assistent).
hatRang(jck,assistent).
hatRang(nlo,assistent).
hatRang(eme,assistent).
hatRang(jkr,hiwi).
hatRang(jwi,hiwi).
hatRang(gen,student).
hatRang(sma,student).
hatRang(tol,student).
%sprädikat -> bestimmt wer wessen boss ist
% prof > assis > hiwi > student
bossVon(X,Y) :- hatRang(X,professor),hatRang(Y,assistent).
bossVon(X,Y) :- hatRang(X,assistent),hatRang(Y,hiwi).
bossVon(X,Y) :- hatRang(X,hiwi),hatRang(Y,student).

%regel: hatGleichenRang
% bestimmt ob 2 Personen den gleichen Rang haben
hatGleichenRang(X,Y) :- hatRang(X,F),hatRang(Y,F). 

%vorgesetzt:  gibt alle Paare aus, wo X einen höheren Rang als Y hat
%d.h alle assitenten sind vorgesetzte von hiwis und studenten
vorgesetzt(X,Y) :- bossVon(X,Y).
vorgesetzt(X,Y) :- bossVon(X,F), vorgesetzt(F,Y).
