package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TokenControllerFixoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGenerateToken() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tokenfixo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("12345678"));
    }
}
//teste antigo
/*package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.controller.TokenController;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenControllerTest {

    @Test
    public void testGenerateToken() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        TokenController tokenController = new TokenController();

        Map<String, String> payload = new HashMap<>();
        payload.put("message", "teste");

        ResponseEntity<?> responseEntity = tokenController.generateToken(payload);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Map<String, String> responseBody = (Map<String, String>) responseEntity.getBody();
        assert responseBody != null;
        assert responseBody.containsKey("token");
    }

    @Test
    public void testGenerateTokenWithoutMessage() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        TokenController tokenController = new TokenController();

        Map<String, String> payload = new HashMap<>();

        ResponseEntity<?> responseEntity = tokenController.generateToken(payload);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Map<String, String> responseBody = (Map<String, String>) responseEntity.getBody();
        assert responseBody != null;
        assertEquals("Nenhuma mensagem provida", responseBody.get("erro"));
    }
}*/
