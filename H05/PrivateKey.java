
import java.math.BigInteger;
/**
 * Repräsentiert einen privaten RSA-Schlüssel bestehend aus (n, e).
 *
 * @param n der RSA-Modulus
 * @param e der private Exponent
 */
public record PrivateKey(BigInteger e, BigInteger n) {
    /**
     * Entschlüsselt einen verschlüsselten Wert c als c^e mod n.
     *
     * @param cipher der verschlüsselte Wert
     * @return die entschlüsselte Nachricht
     */
    public BigInteger decrypt(BigInteger cipher){
        return cipher.modPow(e, n);        
    }
}
