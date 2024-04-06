package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.controller.UsuarioController;
import jakarta.ws.rs.core.Response;

public class UsuarioControllerTest {

    @Test
    public void testValidarSenha() {
        UsuarioController controller = new UsuarioController();
        Response response = controller.validarSenha("k82Q5NwbOYnUxAJ6iywhMg==", "k82Q5NwbOYnUxAJ6iywhMg==");
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(), "Senha validada com sucesso!");
    }
}
