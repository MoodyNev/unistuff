public class ha_prog {
public static void main () {
HWrapper w1 = new HWrapper ();
HWrapper w2 = new HWrapper ();
w1 . i = 0;
w2 . i = 3;
int [] a = { 1 , 2 };
f (a , w1 );

int [] b = { a [0] + a [1] , a [0] * a [1]};
f (b , w1 , w2 );
f ( a );
}
public static void f ( int [] a , HWrapper ... ws ) {
if ( ws . length == 0) {
    IO.println("hey");
a = new int [2];
a [0] = 3;
a [1] = 2 * a [0];
} else {
a [1] += a [0];
ws [ ws . length -1]. i = a [0];
ws [0]. i += ws [ ws . length -1]. i ;
}
IO.println(a[0] + " " + a[1]);
IO.println(ws[0]);
// Speicherzustand jeweils hier zeichnen
}
}
