public sealed class B extends A permits C {
public double d ;
public int i = 4;
public B () {
d = 1.5;
i += super . i ;
}
public double getD () {
return d ;
}
protected long getI () {
return i ;
}
}
