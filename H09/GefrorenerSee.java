
import java.util.*;

/** Aufgabe f:
 * auch nicht generisch, objekte von tier
 * ähnlich wie kaefig aber die tiere können einander nicht fressen
 * fange, fängt und abholen gibt das gesamte set zurück
 * abholen throws leerefalleexception
 * 
 */
public final class GefrorenerSee extends Falle<Tier> {
    private final Set<Tier> see = new HashSet<>();  //nur weil debugger es so wollte, und es ergibt sinn

    @Override
    public void fange(Tier t){
        see.add(t);
    }

    @Override
    public Set<Tier> abholen() throws LeereFalleException{
        if(see.isEmpty()) throw new LeereFalleException();
        return see;
    }
}
