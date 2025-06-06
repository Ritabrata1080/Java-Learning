/**
 * Created by Ritabrata
 * 3DES Algorithm
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
 * Implement 3DES algorithm to promote Confidentiality
 * between two peers who agreed upon SA standards
 */
public class encryption_TripleDES {

    // Generates a 3DES key (168 bits)
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
        keyGen.init(168); // 3DES = 3 x 56-bit keys
        return keyGen.generateKey();
    }

    // Encrypts a plain text string using 3DES
    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypts a Base64 encrypted string back to plain text
    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decrypted, "UTF-8");
    }

    // Demo usage
    public static void main(String[] args) throws Exception {
        StringBuilder plainText = new StringBuilder();

        // Generate 3DES key
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
        // Encrypt
        String encrypted = encrypt(plainText.toString(), key);
        System.out.println("Encrypted: " + encrypted);

        // Decrypt
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);
    }
}
