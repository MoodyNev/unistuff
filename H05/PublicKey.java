
import java.math.BigInteger;
/**
 * Repräsentiert einen öffentlichen RSA-Schlüssel bestehend aus (n, d).
 *
 * @param n der RSA-Modulus
 * @param d der öffentliche Exponent
 */
public record PublicKey(BigInteger d, BigInteger n) {
    /**
     * Verschlüsselt eine Nachricht m als m^d mod n.
     *
     * @param message die zu verschlüsselnde Zahl
     * @return der verschlüsselte Wert
     */
    public BigInteger encrypt(BigInteger message){
        return message.modPow(d,n);
    }
    
}
