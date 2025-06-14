/**
 * Created by Ritabrata
 * AES Algorithm
 */

package encryptionAlgorithms;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author Ritabrata
 *
 * Implement AES algorithm to promote Confidentiality
 * between two peers who agreed upon SA standards
 *
 * This is the most widely used Encryption Algorithm till date.
 */
public class encryption_AES {

    // Generate a 128-bit AES key
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Options: 128, 192, or 256 bits
        return keyGen.generateKey();
    }

    // Generate a 16-byte IV for AES
    public static IvParameterSpec generateIV() {
        byte[] iv = new byte[16]; // 16 bytes = 128 bits
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    // Encrypt plaintext using AES/CBC/PKCS5Padding
    public static String encrypt(String plainText, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));

        // Return IV + encrypted as Base64
        byte[] ivBytes = iv.getIV();
        byte[] combined = new byte[ivBytes.length + encryptedBytes.length];
        System.arraycopy(ivBytes, 0, combined, 0, ivBytes.length);
        System.arraycopy(encryptedBytes, 0, combined, ivBytes.length, encryptedBytes.length);

        return Base64.getEncoder().encodeToString(combined);
    }

    // Decrypt ciphertext using AES/CBC/PKCS5Padding
    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        byte[] combined = Base64.getDecoder().decode(encryptedText);

        // Split IV and ciphertext
        byte[] ivBytes = new byte[16];
        byte[] encryptedBytes = new byte[combined.length - 16];
        System.arraycopy(combined, 0, ivBytes, 0, 16);
        System.arraycopy(combined, 16, encryptedBytes, 0, encryptedBytes.length);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ivBytes));
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes, "UTF-8");
    }

    // Sample plain text to encrypt and then decrypt
    public static void main(String[] args) throws Exception {
        StringBuilder plainText = new StringBuilder();

        // Generate AES key and IV
        SecretKey key = generateKey();
        IvParameterSpec iv = generateIV();

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
        String encrypted = encrypt(plainText.toString(), key, iv);
        System.out.println("Encrypted: " + encrypted);

        // Decrypt
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);
    }
}
