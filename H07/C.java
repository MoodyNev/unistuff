public class C {
	public static void main() {
		// a)
		IO.println("Aufgabe 1:");
		A a1 = new A(5); //(1)
		IO.println (A.x);
		IO.println (a1.y);
		IO.println("Aufgabe 2:");
		A a2 = new A(); //(2)
		IO.println (A.x);
		IO.println (a2.y);
		IO.println("Aufgabe 3:");
		B b = new B(); //(3)
		IO.println (A.x);
		IO.println (b.x);
		IO.println (((A) b).y);
		IO.println (b.y);
		IO.println("Aufgabe 4:");
		A ab = new B(3); //(4)
		IO.println (ab.y);
		IO.println (((B) ab).y);
		
		// b)
		int i = 1;
		long l = 2;
		double d = 3.0;
		a1.f(i, a1); //(1)
		a1.f(l, ab); //(2)
		b.f(i, (B) ab); //(3)
		b.f(d, ab); //(4)
		ab.f(i, a1); //(5)
		ab.f(i, b); //(6)
	}
}