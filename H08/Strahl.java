import java.math.*;
public sealed class Strahl extends Gerade permits Strecke {
    private boolean istP1erste; 
    public Strahl(Punkt a, Punkt b)throws SinglePointException{
        if(istP1erste){
            a = p1;
            b = p2;
        }
        else{
            a = p2;
            b = p1;
        }

    }
    
    @Override
    public String toString(){
        return "Strahl durch" + p1.toString() + "und" + p2.toString();
    }
}
