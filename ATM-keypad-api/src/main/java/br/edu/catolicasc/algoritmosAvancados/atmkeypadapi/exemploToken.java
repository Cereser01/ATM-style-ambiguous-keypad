package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TokenController {

    private static final String ENCRYPTION_KEY = "el chavo";

    @PostMapping("/token")
    public Map<String, String> generateToken(@RequestBody Map<String, String> payload) {
        Map<String, String> response = new HashMap<>();
        if (payload.containsKey("message")) {
            try {
                String encrypted = encryptMessage(payload.get("message"), ENCRYPTION_KEY);
                response.put("token", encrypted);[
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                response.put("erro", "Criptografia falhou");
            }
        } else {
            response.put("erro", "Nenhuma mensagem provida");
        }
        return response;
    }

    private String encryptMessage(String message, String key) throws Exception {
        byte[] byteKey = Base64.getDecoder().decode(key);
        SecretKeySpec secretKey = new SecretKeySpec(byteKey, "AES");

        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] byteCipherText = aesCipher.doFinal(message.getBytes());

        return Base64.getEncoder().encodeToString(byteCipherText);
    }
}
