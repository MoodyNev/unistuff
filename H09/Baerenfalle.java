/** Aufgabe d:
 * die klasse kann nur ein enziges objekt speichern
 * 
 * 
 * 
 */
public final class Baerenfalle<T extends Tier> extends Falle<T> {

    private T objekt;

    @Override
    public void fange(T t){
        if(t == null) return;
        objekt = t;

    }

    @Override
    public java.util.Set<T> abholen() throws LeereFalleException{ 
        //gemini did i dont still understand this bit
        if(objekt == null) throw new LeereFalleException();
        java.util.Set<T> setT = new java.util.HashSet<>();
        setT.add(objekt);

        this.objekt = null;
        return setT;
    }

}
