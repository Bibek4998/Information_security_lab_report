// Write a java program to implement the caesar cipher decryption.
import java.util.Scanner;
public class CaesarDecryption {
    public static String decrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26;
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char ch = (char)(((c - 'A' - shift + 26) % 26) + 'A');
                result.append(ch);
            } else if (Character.isLowerCase(c)) {
                char ch = (char)(((c - 'a' - shift + 26) % 26) + 'a');
                result.append(ch);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ciphertext: ");
        String text = sc.nextLine();
        System.out.println("Enter shift key used for encryption: ");
        int shift = sc.nextInt();
        String decrypted = decrypt(text, shift);
        System.out.println("Decrypted text: " + decrypted);
        sc.close();
    }
}