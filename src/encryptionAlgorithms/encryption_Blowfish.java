/**
 * Created by Ritabrata
 * Blowfish Algorithm
 */

package encryptionAlgorithms;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

/**
 * @author Ritabrata
 *
 * Implement Blowfish algorithm to promote Confidentiality
 * between two peers who agreed upon SA standards
 */

public class encryption_Blowfish {

    // Encrypts the plain text using Blowfish algorithm
    public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypts the encrypted text using Blowfish algorithm
    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes, "UTF-8");
    }

    // Generate Blowfish key
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("Blowfish");
        keyGen.init(128); // Key size: 32 to 448 bits. 128 bits is standard.
        return keyGen.generateKey();
    }

    // Main method for demonstration
    public static void main(String[] args) throws Exception {
        StringBuilder plainText = new StringBuilder();
        String line;
        // Generate key
        SecretKey key = generateKey();
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/encryptionAlgorithms/secretPlainText.txt"))) {
            while ((line = reader.readLine()) != null) {
                plainText.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Encrypt the message
        String encrypted = encrypt(plainText.toString(), key);
        System.out.println("Encrypted: " + encrypted);

        // Decrypt the message
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);
    }
}
