package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi;

import br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.controller.TokenController;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenControllerTest {

    @Test
    public void testGenerateToken() throws Exception {
        TokenController tokenController = new TokenController();
        ResponseEntity<String> response = tokenController.generateToken();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        String token = response.getBody();
        // Verifica se o token tem 8 dígitos
        assertEquals(8, token.length());
        // Verifica se o token é um número
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            assert false; // falha se o token não for um número
        }
    }
}


