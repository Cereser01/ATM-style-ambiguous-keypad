package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CriptografiaTest {
    @Test
    public void testCriptografiaAES() {
        String nome = "testUser";
        String password = "testPassword";
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setPassword(password);

        // Test encryption and decryption
        String encryptedPassword = Usuario.CriptografiaAES.criptografar(password, nome);
        String decryptedPassword = Usuario.CriptografiaAES.decriptografar(encryptedPassword, nome);

        assertEquals(password, decryptedPassword, "Decrypted password should match the original password");

        // Test password setter and getter
        assertEquals(usuario.getPassword(), decryptedPassword, "Password returned by getter should match the original password");
    }
}
