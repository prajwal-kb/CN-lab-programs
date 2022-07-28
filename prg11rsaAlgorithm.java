import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;

public class prg11rsaAlgorithm {
    static BigInteger p , q , n , phi , e, d;
    static SecureRandom sr;
    static int bitLength = 64;
    
    static String encrypt(String msg){
        return new BigInteger(msg.getBytes()).modPow(e, n).toString();
    }
    static String decrypt(String cipher){
        BigInteger bi = new BigInteger(cipher).modPow(d, n);
        return new String(bi.toByteArray());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sr = new SecureRandom();
        p = BigInteger.probablePrime(bitLength, sr);
        q = BigInteger.probablePrime(bitLength, sr);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitLength/2, sr);
        while(e.gcd(phi).compareTo(BigInteger.ONE) != 0 && e.compareTo(phi) < 0)    {
            e = e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
        System.out.println("P assigned as : "+p);
        System.out.println("Q assigned as : "+q);
        System.out.println("N assigned as : "+n);
        System.out.println("PHI assigned as : "+phi);
        System.out.println("The public key : "+e);
        System.out.println("The private key : "+d);
        System.out.println("Enter the Message : ");
        String msg = sc.nextLine();
        String encryptedMassage = encrypt(msg);
        String decryptedMessage = decrypt(encryptedMassage);
        
        System.out.println("Encrypted Message : "+encryptedMassage);
        System.out.println("Decrypted Message : "+decryptedMessage);
        sc.close();
    }
}