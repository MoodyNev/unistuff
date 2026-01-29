/*ich versuche das schlau zu machen, weil ich cool sein möchte*/
/*cool sein hat nicht so wirklich geklappt:(
the console doesnt give it as final reason
something true is false after the semicolon i am confused
couple(widow,me).
couple(daughter, father).
married(X,Y) :- couple(X,Y).
married(X,Y) :- couple(Y,X).*/

married(widow,me).
married(me,widow).
married(daughter,father).
married(father,daughter).

leiblich(father, me).
leiblich(widow, daughter).
parent(X,Y) :- married(X,Z), leiblich(Z,Y).

grandparent(X,Y) :- parent(X,A) , parent(A,Y).
