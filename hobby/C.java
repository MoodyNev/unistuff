public non-sealed class C extends B {
public double d ;

public C ( Double d , int i ) {
this . d = d ;
this . i = i ;
}

public static A foo () {
C c = new C ((double)13.11  , A.i );
return c ;
}

public long getI () {
return ( i > 0);
}

}