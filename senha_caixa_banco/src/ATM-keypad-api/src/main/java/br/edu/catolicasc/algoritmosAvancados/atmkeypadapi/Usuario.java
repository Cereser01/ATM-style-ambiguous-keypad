package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

@Entity
@Table
public class Usuario {
    @Id 
    @GeneratedValue
    private Long id;
    private String nome;
    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        String a = this.nome;
        a = CriptografiaAES.decriptografar(a, "coringuei");
        return a;
        //return this.nome;
    }

    public void setNome(String nome) {
        String a = CriptografiaAES.criptografar(nome, "coringuei");
        this.nome = a;
        //this.nome = nome;
    }

    public String getPassword() {
        String a = this.password;
        a = CriptografiaAES.decriptografar(a, CriptografiaAES.decriptografar(this.nome, "coringuei"));
        return a;
    }

    public void setPassword(String password) {
        String a = CriptografiaAES.criptografar(password, CriptografiaAES.decriptografar(this.nome, "coringuei"));
        this.password = a;
    }

    public static class CriptografiaAES {
        private static final String ALGORITHM = "AES";
        private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
        private static final int ITERATIONS = 10000;
        private static final int KEY_LENGTH = 128; // 128 bits = 16 bytes

        public static String criptografar(String plaintext, String nome) {
            try {
                SecretKeySpec secretKey = gerarChave(nome);
                Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
                return Base64.getEncoder().encodeToString(encryptedBytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public static String decriptografar(String ciphertext, String nome) {
            try {
                SecretKeySpec secretKey = gerarChave(nome);
                Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] encryptedBytes = Base64.getDecoder().decode(ciphertext);
                byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
                return new String(decryptedBytes, StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        private static SecretKeySpec gerarChave(String nome) {
            try {
                SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                KeySpec spec = new PBEKeySpec(nome.toCharArray(), nome.getBytes(StandardCharsets.UTF_8), ITERATIONS, KEY_LENGTH);
                SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), ALGORITHM);
                return secretKey;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    
}

