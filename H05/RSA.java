
import java.math.BigInteger;
import java.util.Random ;

/*
 * you are gonna use bigInteger
 * RAS
 * öffentlichen Schlüssel (n,d)
 * privaten Schlüssel (n,e)
 * m = "Nachrichtenanzahl"
 * c= verschlüsselte Nachricht
 * c = m^d mod n  dann kann weiter entschlüsselt werden 
 * m = c^e mod n
 * 
 * drei Attribute d, e und n (typ bigInteger)
 * 
 */

/**
 * Die Klasse RSA erzeugt zu zwei Primzahlen p und q ein RSA-Schlüsselpaar
 * und bietet Methoden zur Berechnung von phi(p,q), zur Erzeugung eines
 * teilerfremden Exponenten e und zur Rückgabe des öffentlichen und privaten Schlüssels.
 */
public class RSA {
    private BigInteger n, d, e;

    /**
     * Erzeugt ein RSA-Objekt aus zwei Primzahlen.
     *
     * @param p erste Primzahl
     * @param q zweite Primzahl
     */    
    public RSA(BigInteger p, BigInteger q){
        n = p.multiply(q);
        BigInteger phi = eulerPhi(p,q);
        e = generateCoprime(phi);
        d = e.modInverse(phi);
    }

    /**
     * Erzeugt ein RSA-Objekt aus zwei long-Werten, die Primzahlen darstellen.
     *
     * @param p erste Primzahl
     * @param q zweite Primzahl
     */
    public RSA(long p, long q){
        BigInteger p1, q1;
        p1 = BigInteger.valueOf(p);
        q1 = BigInteger.valueOf(q);
        //RSA(p1,q1); THROWS AND ERROR IDK WHY
        BigInteger phi = eulerPhi(p1,q1);
        e = generateCoprime(phi);
        n = p1.multiply(q1);
        d = e.modInverse(phi);
    }

    /**
     * Gibt den öffentlichen Schlüssel (n, d) zurück.
     *
     * @return ein PublicKey-Objekt
     */
    PublicKey publicKey(){
        //PublicKey publicKey = new PublicKey(n,d);
        return new PublicKey(d,n);
    }

    /**
     * Gibt den privaten Schlüssel (n, e) zurück.
     *
     * @return ein PrivateKey-Objekt
     */
    PrivateKey privateKey(){
        return new PrivateKey(e,n);
    }
    
    /**
     * Berechnet die Eulersche Phi-Funktion φ(p,q) = (p - 1) * (q - 1).
     *
     * @param p erste Primzahl
     * @param q zweite Primzahl
     * @return Wert von φ(p,q)
     */
    public static BigInteger eulerPhi(BigInteger p, BigInteger q){
        BigInteger phi, p1, q1;
        p1 = (p.subtract(BigInteger.ONE));
        q1 = (q.subtract(BigInteger.ONE));
        phi = p1.multiply(q1);
        return phi;
    }

    /**
     * Vergleicht zwei BigInteger-Typen a.compareTo(b)
     * @param a erste BigInteger
     * @param b zweite BignInteger
     * @return falls a is kleiner als b: true, else: false
     */
    public static boolean lessThan(BigInteger a, BigInteger b){
        int result = a.compareTo(b);
        //HOLY THIS IS SO SMART THANK YOU DEBUGGER
        return result < 0; 
    }

    /**
     * Erzeugt eine zufällige Zahl e, die teilerfremd zu x ist und im Bereich 1 < e < x liegt.
     *
     * @param x die Zahl, zu der e teilerfremd sein soll
     * @return eine positive Zahl e mit gcd(e, x) = 1
     */
    public static BigInteger generateCoprime(BigInteger x){
        BigInteger e;
        //überprüft die gcd
        do{
            e = new BigInteger(x.bitLength(), new Random());
        } while(!e.gcd(x).equals(BigInteger.ONE) || lessThan(e, BigInteger.ONE) || lessThan(x, e));
        return e;
    }
}
