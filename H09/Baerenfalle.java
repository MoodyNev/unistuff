import java.util.*;
/** Aufgabe d:
 * die klasse kann nur ein enziges objekt speichern
 * 
 * 
 * 
 */
public final class Baerenfalle<T extends Tier> extends Falle<T> {

    private T objekt;

    //old java was dumb so we keep doing unncessary stuff
    public Baerenfalle() {
    }

    @Override
    public void fange(T t){
        if(objekt == null) objekt = t;
    }

    @Override
    public Set<T> abholen() throws LeereFalleException{ 
        //weil abstrakte falle, das so vorgegeben hat
        if(objekt == null) throw new LeereFalleException();
        Set<T> setT = new HashSet<>();
        setT.add(objekt);
        return setT;
    }

}
