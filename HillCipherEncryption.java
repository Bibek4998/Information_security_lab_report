// Write a java program to implement the hill cipher encryption.
import java.util.Scanner;
public class HillCipherEncryption {
    static int[][] key = new int[2][2];
    static int charToInt(char c) {
        return c - 'a';
    }
    static char intToChar(int n) {
        return (char)(n + 'a');
    }
    static String encrypt(String message, int[][] key) {
        StringBuilder cipher = new StringBuilder();
        if (message.length() % 2 != 0) {
            message += 'x';
        }
        for (int i = 0; i < message.length(); i += 2) {
            int[] pair = { charToInt(message.charAt(i)), charToInt(message.charAt(i + 1)) };
            int c1 = (key[0][0] * pair[0] + key[0][1] * pair[1]) % 26;
            int c2 = (key[1][0] * pair[0] + key[1][1] * pair[1]) % 26;
            cipher.append(intToChar(c1)).append(intToChar(c2));
        }
        return cipher.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2x2 key matrix (4 integers between 0-25):");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                key[i][j] = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter plaintext (lowercase only):");
        String plaintext = sc.nextLine().replaceAll("[^a-z]", "");
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Encrypted text: " + ciphertext);
        sc.close();
    }
}
