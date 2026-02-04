%eine aufstiegend sortierte Liste Fs
%berechnet alle Primfaktoren von N

%weirdly dont do `;` with this idk the reason yet,
%but i think it bruteforces its way to the next function
factorization(1,[]).
factorization(N,Fs) :- [divideNumberWith(N,D,Fs)|Fs].

%!!!!I DONT STILL KNOW HOW TO USE LISTS STILL HELP, WE ARE DIVING INTO ADDING LATER

%so we have the number N that needs to be divided with divisor D until the mod is 0
divideNumberWith(1,D,[]).
divideNumberWith(N,D,[D|Fs]) :-
0 is (N mod D),
M is (N div D),
divideNumberWith(M, D, Fs).

%i am not going to consider the case where the number is one
%because factorization automatically covers that

%this fella takes the old prime
%and increases the number until it finds the next prime number
findNextPrime(OldPrime, NewPrime) :- checkIfPrime(1, NewPrime).
findNextPrime(OldPrime + 1, NewPrime) :-
C is OldPrime + 1,
findNextPrime(C, NewPrime).

%this fella takes a number and increases the first number until it is equal to itself
%i know it is inefficient, since it check everynumber from two all the time, it would have been smarter to collect them in a list
%BUT PROLOG DOEST HAVE FOR-LOOPS
checkIfPrime(N,N).
checkIfPrime(M,N) :-
0 < N mod M,
L is M + 1,
checkIfPrime(L, N).

/* Plan is to take the number
until the mod is not 0 anymore
then we call a function called findNextPrime
it finds the next prime
we go back to diving
we do this until the number are diving is 0
*/