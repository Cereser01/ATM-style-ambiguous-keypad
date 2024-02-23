import org.springframework.web.bind.annotation.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TokenController {

    @PostMapping("/token")
    public Map<String, String> generateToken(@RequestBody Map<String, String> payload) {
        Map<String, String> response = new HashMap<>();
        if (payload.containsKey("message") && payload.containsKey("key")) {
            try {
                String encrypted = encryptMessage(payload.get("message"), payload.get("key"));
                response.put("token", encrypted);
            } catch (Exception e) {
                response.put("error", "Encryption failed");
            }
        } else {
            response.put("error", "No message or key provided");
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
