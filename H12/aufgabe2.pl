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

parent(me, daughter).
parent(daugher, me).
parent(father, me).
parent(widow, daughter).

grandparent(X,Y) :- parent(X,A) , parent(A,Y).
