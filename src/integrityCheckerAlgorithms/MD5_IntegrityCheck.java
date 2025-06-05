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
 * MD5_IntegrityCheck.java : Computes MD5 digest for a plaintext
 */
public class MD5_IntegrityCheck {

    public static String getMD5(String input) {
        try {
            // Create MD5 MessageDigest instance
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the hash
            byte[] hashBytes = md.digest(input.getBytes());

            // Convert byte array to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                // Convert byte to hex and pad with leading zero if necessary
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to hash using MD5: ");
        String input = scanner.nextLine();
        String md5Hash = getMD5(input);
        System.out.println("MD5 Digest: " + md5Hash);
    }
}
