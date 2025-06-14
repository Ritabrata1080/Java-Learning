/**
 * Created by Ritabrata
 */

package integrityCheckerAlgorithms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * @author Ritabrata
 *
 * SHA_IntegrityCheck.java : Computes SHA digest for a plaintext
 */

public class SHA_IntegrityCheck {

    public static String computeHash(String input, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] hashBytes = md.digest(input.getBytes());

            // Convert bytes to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash algorithm not found: " + algorithm);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to hash: ");
        String input = scanner.nextLine();

        String sha1 = computeHash(input, "SHA-1");
        String sha256 = computeHash(input, "SHA-256");
        String sha512 = computeHash(input, "SHA-512");

        System.out.println("SHA-1   : " + sha1);
        System.out.println("SHA-256 : " + sha256);
        System.out.println("SHA-512 : " + sha512);
    }
}
