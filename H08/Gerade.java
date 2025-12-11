import java.math.*;
public sealed class Gerade permits Strahl{
    private final Punkt p1;
    private final Punkt p2;

    //p1 and p2 are saved based on their cordinates
    public Gerade(Punkt punkt1, Punkt punkt2) throws SinglePointException{
        if(punkt1.equals(punkt2)){
            throw new SinglePointException(punkt1);
        }

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

    //muss zwischen oder auf einer der punkte liegen
    private boolean zwischenp1p2(Punkt p0){
        BigDecimal abstand01 = p0.abstand(p1);
        BigDecimal abstand02 = p0.abstand(p2);
        BigDecimal abstand12 = p1.abstand(p2);
        return (BigDecimalUtility.equalValues(abstand12,abstand01.add(abstand02)));
        //return (p0.getX().compareTo(p1.getX()) >= 0 && p2.getX().compareTo(p0.getX()) >= 0);
    }

    private boolean vorp1(Punkt p0){
        if(!zwischenp1p2(p0)){
            
        }
        return false;
    }

    private boolean hinterp2(Punkt p0){
        if(!zwischenp1p2(p0) && !vorp1(p0)){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Gerade durch" + p1.toString() + "und" + p2.toString();
    }
}
