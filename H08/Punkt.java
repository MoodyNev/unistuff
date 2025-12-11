
import java.math.*;

/* drei arten von linien 
eine gerade verläuft durch zwei richtungen bis ins unendliche weiter
und die andere möglichkeiten
for best accuracy we use big decimal (java.math.*)

 */

//WE ARE MISSING A STRING  0,0 OVER HERE SO TAKE A LOOK AT THAT FROM AUFGABE A
public class Punkt {

    private final BigDecimal xKoordinate;
    private final BigDecimal yKoordinate;

    //Setter
    //parameter as big decimal
    public Punkt(BigDecimal x, BigDecimal y){
        this.xKoordinate = x;
        this.yKoordinate = y;
    }

    //parameter as double, it converts them to save them 
    public Punkt(double x, double y){
        this(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
        //xKoordinate = BigDecimal.valueOf(x);
        //yKoordinate = BigDecimal.valueOf(y);
    }

    //Getter
    public BigDecimal getX(){
        return xKoordinate;
    }

    public BigDecimal getY(){
        return yKoordinate;
    }
    
    //formel für die abstandberechnung: d = \sqrt((x1-x2)² + (y1-y2)²)
    public BigDecimal abstand(Punkt other){
        //geht noch kürzer, du muss nicht alles deklarieren
        BigDecimal x1 = this.getX();
        BigDecimal y1 = this.getY();
        BigDecimal x2 = other.getX();
        BigDecimal y2 = other.getY();
        //i know it looks unreadable and complicated but trust me it works and is the exact formula above
        return BigDecimalUtility.sqrt(((x1.subtract(x2)).pow(2)).add((y1.subtract(y2)).pow(2)));
    }
    
    //idk why debugger said so
    //please dont judge me for the programmer i am, giving my best to learn
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Punkt)){
            return false;
        }
        BigDecimal x1 = this.getX();
        BigDecimal y1 = this.getY();
        BigDecimal x2 = ((Punkt) obj).getX();
        BigDecimal y2 = ((Punkt) obj).getY();
        return BigDecimalUtility.equalValues(x1,x2) && BigDecimalUtility.equalValues(y1,y2);
    }

    public String toString(){
        return "(" + xKoordinate + "," + yKoordinate + ")";
    }
}
