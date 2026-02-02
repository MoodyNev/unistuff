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

findNextPrime(OldPrime, NewPrime)


/* Plan is to take the number
until the mod is not 0 anymore
then we call a function called findNextPrime
it finds the next prime
we go back to diving
we do this until the number are diving is 0
*/