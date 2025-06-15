// Write a java program to implement hill cipher decryption.
import java.util.Scanner;
public class HillCipherDecryption {
    static int[][] key = new int[2][2];
    static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1) return x;
        return -1;
    }
    static int[][] inverseKey(int[][] key) {
        int det = key[0][0]*key[1][1] - key[0][1]*key[1][0];
        det = (det % 26 + 26) % 26;
        int detInv = modInverse(det, 26);
        if (detInv == -1) {
            System.out.println("Key is not invertible!");
            System.exit(1);
        }
        int[][] inv = new int[2][2];
        inv[0][0] = key[1][1];
        inv[1][1] = key[0][0];
        inv[0][1] = -key[0][1];
        inv[1][0] = -key[1][0];

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                inv[i][j] = (inv[i][j] * detInv % 26 + 26) % 26;
        return inv;
    }
    static int charToInt(char c) {
        return c - 'a';
    }
    static char intToChar(int n) {
        return (char)(n + 'a');
    }
    static String decrypt(String cipher, int[][] key) {
        StringBuilder plain = new StringBuilder();
        int[][] invKey = inverseKey(key);
        for (int i = 0; i < cipher.length(); i += 2) {
            int[] pair = { charToInt(cipher.charAt(i)), charToInt(cipher.charAt(i + 1)) };
            int p1 = (invKey[0][0] * pair[0] + invKey[0][1] * pair[1]) % 26;
            int p2 = (invKey[1][0] * pair[0] + invKey[1][1] * pair[1]) % 26;
            plain.append(intToChar(p1)).append(intToChar(p2));
        }
        return plain.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2x2 key matrix used for encryption:");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                key[i][j] = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter ciphertext (lowercase only):");
        String ciphertext = sc.nextLine().replaceAll("[^a-z]", "");

        String plaintext = decrypt(ciphertext, key);
        System.out.println("Decrypted text: " + plaintext);
        sc.close();
    }
}