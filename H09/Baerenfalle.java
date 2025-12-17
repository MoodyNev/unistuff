import java.util.*;
/** Aufgabe d:
 * die klasse kann nur ein enziges objekt speichern
 * 
 * 
 * 
 */
public non-sealed class Baerenfalle<T extends Tier> extends Falle<T> {

    private T objekt;

    @Override
    public void fange(T t){
        if(t == null) return;
        objekt = t;

    }

    @Override
    public Set<T> abholen() throws LeereFalleException{ 
        //gemini did i dont still understand this bit
        if(objekt == null) throw new LeereFalleException();
        Set<T> setT = new HashSet<>();
        setT.add(objekt);

        this.objekt = null;
        return setT;
    }

}
