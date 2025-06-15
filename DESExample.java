import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;
public class DESExample {
    public static void main(String[] args) throws Exception {

        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey secretKey = keyGen.generateKey();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to encrypt: ");
        String plaintext = sc.nextLine();

        Cipher encryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = encryptCipher.doFinal(plaintext.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted: " + encryptedText);

        Cipher decryptCipher = Cipher.getInstance("DES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted: " + decryptedText);
        sc.close();
    }
}