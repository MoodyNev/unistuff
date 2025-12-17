/** Aufgabe a: 
 * Jedes Tier, String name and int alter
 * keine objekte darf in tier erstellt werden
 * für jede der 4 Klassen erstelle einen Konstruktor,
 * die die Attribute initialisiert -> parameter: String und int
 * es muss get methoden geben
 * und eine toString methode
 * keine unterklassen von den vier implementierten klassen
**/
public sealed abstract class Tier permits Hase, Biber, Waschbaer {
    String name;
    int alter;

    Tier(String name, int alter){
        this.name = name;
        this.alter = alter;
    }

    int getAlter(){
        return alter;
    }

    String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "(Alter: " + alter + ")";
    }
}
