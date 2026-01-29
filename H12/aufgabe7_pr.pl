%Teilaufgabe a) 
%definiere alle Skipisten nach deren Schwierigkeit
%start:
start(teufeltal).
start(sonnalm).
%pfad
endetIn(teufeltal,wiesenalm).
endetIn(sonnalm,vorkogel).
endetIn(sonnalm,arbiskogel).
endetIn(vorkogel,isskogel).
endetIn(arbiskogel,plattenalm).
endetIn(plattenalm,wiesenalm).

%ende
endetIn(isskogel,tal).
endetIn(wiesenalm,tal).

%Schwiergkeit
blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(plattenalm).
blau(wiesenalm).
rot(isskogel).
schwarz(teufeltal).

%Teilaufgabe b)
%bestimmt die Länge der übergebenen Liste



pathOfLength(cons(tal,nil),0).
pathOfLength(cons(Kopf, Rest), s(L)) :- endetIn(Kopf, Next),
                                        Rest = cons(Next,_),
                                        pathOfLength(Rest,L).

%Teilaufgabe c)
/*
für tourOfLength(X,0) = cons(tal,nil)
wenn der Tal erreicht wird und die List nicht der Länge entspricht,fängt das System wieder 
an einem start an und erstellt eine Liste zum Tal

fange mit append an und erstelle eine Liste mit dem start

*/

add(X,0,X).
add(X,s(Y),s(Z)) :- add(X,Y,Z).

append(nil, YS, YS).
append(YS,nil,YS).
append(cons(Kopf,Rest), YS, cons(Kopf,XS)):- append(Rest,YS,XS).

%entfernt den tal am Ende von jedem neu erstellten Tour, s.d es keine Doppelte Aufzählung von Pfad gibt
remove(cons(tal,nil),Rest,Rest).
remove(cons(Kopf,R), Rest,cons(Kopf,XS)) :- Kopf\= tal,remove(R,Rest,XS).

%Basisfall
%reverse funktioniert nicht, wenn die Eingabe liste keine gültige Tour ist
tourOfLength(cons(tal,nil),0). 
tourOfLength(cons(tal,Gesamt),s(L)) :- 
%wir definieren die Gesamtlänge als eine Variable
GesamtL = s(L),
%Addition von L1 und L2 ergibt Gesamtlänge, d.h wir fordern, dass L1 und L2 kleiner
%gleich Gesamtlänge sind
add(L1,L2,GesamtL),

%dabei ist L1 ein Summand mit einer unbekannten Länge
L1 = s(_),
%P ist eine Liste, die aus einem Kopf und einem Rest besteht
P= cons(Kopf,_),
%es soll gelten, dass der Kopf, auch ein gültiger Startpunkt ist, also (sonnalm oder teufeltal)
start(Kopf),
%es wird ein Pfad mit der Länge L1 erstellt, die im Tal endet
pathOfLength(P,L1),
%mit der übrigen länge wird eine weitere List erstellt mit der übrigen Länge L2
%rekursive wiederholung des oberen Prozessen
tourOfLength(RestListe,L2),
%zusammenfügen von der gerade erstellten Liste P und der rekuriv erstellten RestListe
append(R1,RestListe,Gesamt).
%Am anfang muss auch tal stehen
                          
                          
                                                       
/*Teilaufgabe d
  partTour(P,T) ist wahr,wenn ein Tour von T in P enthalten ist
  bsp. T= [tal,teufeltal, wiesenalm tal, sonnalm, vorkogel, isskogel,tal], 
  dann muss gelten P= [tal,teufeltal,wiesenalm tal] oder P =[tal, sonnalm, vorkogel, isskogel,tal] oder P=T*/

/*partTour(_,nil).
partTour(T,T).
partTour(P,T) :- */



%Teilaufgabe e)
%konvertiert die cons-Liste in die von Prolog vordefinierte List und umgekehrt
convert(nil,[]).
convert(cons(Kopf,Rest),[Kopf|Xs]) :-   convert(Rest,Xs).

%Teilaufgabe f) trial
%test berechnet einen Pfad vom Start nach tal
%dabei wird vor dem Start nochmal tal an die Liste konkatenier
enumerateTours(0,cons(tal,nil)).
enumerateTours(s(L), Korrektur) :-
    start(Kopf),
    pathOfLength(P, s(L)),
    P = cons(Kopf,_),
    Korrektur = cons(tal,P).


enumerate(T):- enumerateTours(L,P),
               convert(P,T).

%Teilaufgabe g)
tourRotSchwarz(T,R,S) :- enumerate(Tour),
                         countRS(Tour,R,S)
                         T=Tour.





%Hilfsprädikat
checkRot(0,[],0).
checkRot(0,[_],0).
checkRot(s(Anzahl),[X,T|Tour],Ergebnis) :- rot(X), checkRot(Anzahl,[T|Tour],s(Ergebnis)).
checkRot(Anzahl,[X,T|Tour],Ergebnis) :- checkRot(Anzahl,[T|Tour],Ergebnis).

                   
countRS([], 0, 0).

countRS([_], 0, 0).

countRS([X,Y|Rest], R, S) :-
    rot(X),
    countRS([Y|Rest], R1, S),
    R = s(R1).

countRS([X,Y|Rest], R, S) :-
    schwarz(X),
    countRS([Y|Rest], R, S1),
    S = s(S1).

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