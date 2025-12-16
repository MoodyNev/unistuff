/** Aufgabe c:
 * Falle<T> für beliebige Fälle, die Tiere vom Typ T fangen können
 * in falle klasse darf keine obejkte erstellt werden
 * fallen stellen spezielle container dar
 * zwei methode: fange und set<T> abholen
*/
public abstract sealed class Falle<T extends Tier> permits Kaefig, GefrorenerSee, Baerenfalle {
    
    abstract void fange(T t);

    abstract java.util.Set<T> abholen() throws LeereFalleException;
}
