public class A {
private int i1 ; 
private Integer i2 ;
private short s ; //hier werden 3 variablen deklariert, zwei primitiver Datentype ein int und ein short und ein Hüllenklassentyp Integer
  
public A ( Short s , int i ) {
this . i1 = s ; //ist ein short 1 (boxxing ig?)
this . i2 = i ; //automatischer boxxing 
this . s = s ;
}

public void f ( Integer i ) {
IO . println ( " f1 " );
}

public void f ( String s ) {
IO . println ( " f2 : " + s );
}

public void f ( double d ) {
IO . println ( " f3 " );
}

public void g ( int i , float d ) {
IO . println ( " g1 " );
}

public void g ( Integer i , Long j ) {
IO . println ( " g2 " );
}

public void g ( int ... is ) {
IO . println ( " g3 " );
}

public void g ( double ... is ) {
IO . println ( " g4 " );
}

public static void main () {
A a = new A (( short )1 ,2);
a . f ( a . i1 ); 
a . f ( a . i2 ); 
a . f ( a . s ); 
a . f (.0f );
a . g (1 ,2); 
a . g (1 ,2L );
a . g ( a . i2 , Long . valueOf (2)); 
a . g (1 ,2.0); 
a . g (1 ,2.0f );
}

}