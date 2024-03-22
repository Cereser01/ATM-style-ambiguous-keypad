package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.controller;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/token")
public class TokenController {

    private static final int TOKEN_LENGTH = 8;
    private static final int MIN_TOKEN_VALUE = 10000000; // Ensures 8-digit number
    private static final int MAX_TOKEN_VALUE = 99999999; // Ensures 8-digit number
    private static Set<Integer> generatedTokens = new HashSet<>();
    private static SecureRandom random = new SecureRandom();
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final int KEY_SIZE = 128; // 128-bit key length
    public static byte[] generateIv() {
        byte[] iv = new byte[16];
        return iv;
    }
    public static byte[] encrypt(byte[] data, byte[] key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        return cipher.doFinal(data);
    }

    public static String encryptToString(byte[] data, byte[] key, byte[] iv) throws Exception {
        byte[] encryptedData = encrypt(data, key, iv);
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static byte[] decrypt(byte[] data, byte[] key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        return cipher.doFinal(data);
    }
    public static String decryptToString(String encryptedData, byte[] key, byte[] iv) throws Exception {
        byte[] data = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = decrypt(data, key, iv);
        return new String(decryptedData);
    }

    @GetMapping
    public ResponseEntity<String> generateToken() throws Exception {
        
        int token;
        do {
            token = random.nextInt(MAX_TOKEN_VALUE - MIN_TOKEN_VALUE + 1) + MIN_TOKEN_VALUE;
        } while (generatedTokens.contains(token) && generatedTokens.size() < 1000);
        String key = "0x1234567890abcd"; // 16 bytes
        byte[] iv = generateIv(); // gera uma chave IV aleatória de 16 bytes
        generatedTokens.add(token);
        String data = Integer.toString(token);
        byte[] encryptedData = encrypt(data.getBytes(), key.getBytes(), iv);
        String encryptedString = Base64.getEncoder().encodeToString(encryptedData);
        return ResponseEntity.ok(data);
    }
}
