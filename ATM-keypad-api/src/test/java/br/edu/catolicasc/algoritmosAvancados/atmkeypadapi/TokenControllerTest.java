package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TokenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGenerateUniqueToken() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/token"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.matchesRegex("[0-9]{8}")));
    }

    @Test
    public void shouldGenerateDifferentTokensForMultipleRequests() throws Exception {
        String firstToken = mockMvc.perform(MockMvcRequestBuilders.get("/token"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        String secondToken = mockMvc.perform(MockMvcRequestBuilders.get("/token"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertNotEquals(firstToken, secondToken);
    }
}

