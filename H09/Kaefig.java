import java.util.*;


/** Aufgabe e:
 * nicht mehr genrisch
 * unbegrenzter container für alle Tiere
 * fange -> fügt ein neues Tier ein
 * abholden -> gibt gesamte Set zurück
 * falls sich waschbär im käfig befindet, frisst diese alle Hasen
 * sobald die methode abholen aufgerufen wird (keine haseb wird zurückgegeben)
 * falls die falle leer ist, throws exception
 * 
 * 
 */
public non-sealed class Kaefig extends Falle<Tier> {
    private Set<Tier> kaefig = new HashSet<>();

    @Override
    public void fange(Tier t){
        kaefig.add(t);
    }

    @Override
    public Set<Tier> abholen() throws LeereFalleException{
        if(kaefig.isEmpty()) throw new LeereFalleException();
        for(Tier tier : kaefig){
            if(tier instanceof Waschbaer){
                fressen();
                break;
            }
        }
        return kaefig;
    }

    public void fressen(){         //!!!! why are you working brother??
        for(Tier i : kaefig){
            if(i instanceof Hase){
                kaefig.remove(i);
            }
        }
    }
}
