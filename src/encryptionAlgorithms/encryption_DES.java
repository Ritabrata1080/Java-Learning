/**
 * Created by Ritabrata
 * DES Algorithm
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
 * Implement DES algorithm to promote Confidentiality
 * between two peers who agreed upon SA standards
 */

public class encryption_DES {

    // Encrypts plaintext using DES
    public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypts ciphertext using DES
    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes, "UTF-8");
    }

    // Generate a DES secret key
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56); // DES uses 56-bit key
        return keyGen.generateKey();
    }

    // Main method for testing
    public static void main(String[] args) throws Exception {
        StringBuilder plainText = new StringBuilder();

        // Generate DES key
        SecretKey key = generateKey();
        String line;
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/encryptionAlgorithms/secretPlainText.txt"))) {
            while ((line = reader.readLine()) != null) {
                plainText.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Encrypt the plain text
        String encrypted = encrypt(plainText.toString(), key);
        System.out.println("Encrypted Text: " + encrypted);

        // Decrypt the encrypted text
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
