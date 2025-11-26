/* AUFGABENSTELLUNG 
rekursive Bestimmung von die x-Koordinate der Nullstellen
und Extremwerten der quadratische Funktionen
die Werte werden nicht direkt bestimmt, sondern durch eine binäre Suche
eine Abweichung von epsilon bestimmen

Prozess der Rekursion: die oG  und Ug werden solange angepasst bis ihre
Differenz <= epsilon ist
*/
public class nullstellen{
    public static void main(String[] args) {
        IO.println("Result:" + sqrt(0,4,4));
    }

    SquareFun squareFun(){
        return new SquareFun(0, 0, 0);
    }
    
    public static float sqrt(float uG, float oG, float x){
        float m, epsilon = 1e-3f;
        m = (uG + oG) / 2;
        IO.println("uG: " + uG + " oG: " + oG + " m: " + m);
        if(oG - uG <= epsilon) return m;
        else if (m * m > x) return sqrt (uG , m , x);
        else return sqrt (m, oG, x);
    }
}