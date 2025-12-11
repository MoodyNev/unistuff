import java.math.*;
public sealed class Gerade permits Strahl{
    private final Punkt p1, p2;

    //p1 and p2 are saved based on their cordinates
    public Gerade(Punkt punkt1, Punkt punkt2) throws SinglePointException{
        if(punkt1.equals(punkt2)) throw new SinglePointException(punkt1);
        
        int vergleiche = punkt1.getX().compareTo(punkt2.getX());
        if(vergleiche < 0){
            p1 = punkt1;
            p2 = punkt2;
        }
        
        else if(vergleiche > 0){
            p1 = punkt2;
            p2 = punkt1;
        }

        else{
            int vergleicheY = punkt1.getY().compareTo(punkt2.getY());
            p1 = (vergleicheY < 0) ? punkt1 : punkt2;
            p2 = (vergleicheY > 0) ? punkt1 : punkt2;
        }  
    }

    //private in der klasse und protected innerhalb vererbung
    //muss zwischen oder auf einer der punkte liegen
    protected boolean zwischenp1p2(Punkt p0){
        if(p0.equals(p1) || p0.equals(p2)){
            return true;
        }
        BigDecimal abstand01 = p0.abstand(p1);
        BigDecimal abstand02 = p0.abstand(p2);
        BigDecimal abstand12 = p1.abstand(p2);
        //das ist der dreiecks ungleichung
        //ich checke es aber trotzdem wie es bei der funktion zwischen hilft
        return (BigDecimalUtility.equalValues(abstand12,abstand01.add(abstand02)));
    }

    protected boolean vorp1(Punkt p0){
        if(zwischenp1p2(p0)){
            return false;
        }
        BigDecimal abstand01 = p0.abstand(p1);
        BigDecimal abstand02 = p0.abstand(p2);
        BigDecimal abstand12 = p1.abstand(p2);
        return (BigDecimalUtility.equalValues(abstand02, abstand01.add(abstand12)));
    }

    protected boolean hinterp2(Punkt p0){
        if(zwischenp1p2(p0) || vorp1(p0)){
            return false;
        }
        BigDecimal abstand01 = p0.abstand(p1);
        BigDecimal abstand02 = p0.abstand(p2);
        BigDecimal abstand12 = p1.abstand(p2);
        return (BigDecimalUtility.equalValues(abstand01, abstand02.add(abstand12)));
    }

    protected boolean enthaelt(Punkt p0){
        return zwischenp1p2(p0) || vorp1(p0) || hinterp2(p0) ;
    }

    @Override
    //debugger said it cant be private :((
    public boolean equals(Object obj){
        //not sure if whether the object is a gerade or a punkt
        //obj null unnötig
        if(obj == null || !obj.getClass().equals(this)){
            return false;
        }
        Gerade otherGerade = (Gerade) obj;

        //i said it is important to also check for `this` object but i am not sure
        if(otherGerade.enthaelt(this.p1) && otherGerade.enthaelt(this.p2)){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Gerade durch" + p1.toString() + "und" + p2.toString();
    }
}
