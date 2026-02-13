blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(plattenalm).
blau(wiesenalm).
schwarz(teufeltal).
rot(isskogel).

start(sonnalm).
start(teufeltal).

endetIn(sonnalm,vorkogel).
endetIn(sonnalm,arbiskogel).
endetIn(vorkogel,isskogel).
endetIn(arbiskogel,plattenalm).
endetIn(plattenalm,wiesenalm).
endetIn(isskogel,tal).
endetIn(teufeltal,wiesenalm).
endetIn(wiesenalm,tal).

/* falls wir schon am Ziel sind*/
pathOfLength(cons(tal,nil), 0).
pathOfLength(cons(X, cons(Y, Rest)),s(N)) :- 
endetIn(X,Y), pathOfLength(cons(Y,Rest), N).

/* wenn die Länge 0 ist*/
tourOfLength(cons(tal,nil),0).
/*if we are back at the top*/
tourOfLength(cons(tal,T),L) :- 
L1 = s(_),
start(S),
pathOfLength(P, L1),
P = cons(S,_),
add(L1,L2,L),
tourOfLength(cons(tal, R),L2),
my_append(P,R,T).

% 2. Peano-Addition (aus dem Hinweis)
% Wenn man 0 addiert, ändert sich nichts.
add(X, 0, X).
% Wenn man s(Y) addiert, ist das Ergebnis auch eins höher (s(Z)).
add(X, s(Y), s(Z)) :- add(X, Y, Z).

% append aus der GÜ
% Teilaufgabe b)
append([], YS, YS).
append([X|XS], YS, [X|Res]) :- append(XS, YS, Res).

my_append(nil, YS, YS).
my_append(YS,nil,YS).
my_append(cons(X,XS), YS, cons(X,Res)) :- my_append(XS, YS, Res).

%SOGAR DAS RICHTIGE ERGEBNIS GIBT TRUE TRUE FALSE ZÜRUCK HILFE
%das ist warscheinlich was wir am Ende haben (habe auch `nil` gedacht aber ich glaube das stimmt nicht)
%hier war doch kein partTour, sonst manage ich Fehler aufzubauen
%mit einer neuer Prädikat war das doch kein Fehler
checkTour(nil, T).
checkTour(cons(X,P), cons(X,T)):-
checkTour(P,T).

partTour(P,T) :-
tourOfLength(P,X),
tourOfLength(T,Y),
partTour2(P,T).
%der Rest, um springen von Elementen zu vermeiden
%mache ich eine andere Prädikat
partTour2(P,T):-
checkTour(P,T).

%falls das erste Element nicht gleich ist, zerlege die Liste weiter
partTour2(P,T) :-
T = cons(_, T1),
partTour2(P,T1).

%hier kommt die custom append
convert(nil,[]).
convert(cons(X,ResX),[X|ResY]):-
convert(ResX,ResY).
