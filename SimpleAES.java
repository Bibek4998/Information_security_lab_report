import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SimpleAES {
    public static void main(String[] args) throws Exception {
        String key = "1234567890123456"; // 16-char key
        String text = "HelloWorld";

        SecretKeySpec secret = new SecretKeySpec(key.getBytes(), "AES");

        Cipher enc = Cipher.getInstance("AES");
        enc.init(Cipher.ENCRYPT_MODE, secret);
        byte[] encrypted = enc.doFinal(text.getBytes());

        Cipher dec = Cipher.getInstance("AES");
        dec.init(Cipher.DECRYPT_MODE, secret);
        byte[] decrypted = dec.doFinal(encrypted);

        System.out.println("Encrypted: " + new String(encrypted));
        System.out.println("Decrypted: " + new String(decrypted));
    }
}