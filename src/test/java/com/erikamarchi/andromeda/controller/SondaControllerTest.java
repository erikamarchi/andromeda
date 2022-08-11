package com.erikamarchi.andromeda.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SondaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveriaPousarUmaSondaNoPlanetaEMovimentar() throws Exception {
        // cria a sonda
        mockMvc
                .perform(post("/galaxias/andromeda/planetas/0/sondas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                  {
                                      "x":1,
                                      "y":2,
                                      "sentido":"NORTE"
                                  }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value("1"))
                .andExpect(jsonPath("$.y").value("2"))
                .andExpect(jsonPath("$.sentido").value("NORTE"))
        ;

        // movimenta a sonda
        mockMvc
                .perform(post("/galaxias/andromeda/planetas/0/sondas/0/comandos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""" 
                                { "comandos": "LMLMLMLMM" }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value("1"))
                .andExpect(jsonPath("$.y").value("3"))
                .andExpect(jsonPath("$.sentido").value("NORTE"))
        ;

        // pega os dados
        mockMvc
                .perform(get("/galaxias/andromeda/planetas/0/sondas/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value("1"))
                .andExpect(jsonPath("$.y").value("3"))
                .andExpect(jsonPath("$.sentido").value("NORTE"))
        ;

        // outro caso de teste

        // cria a sonda
        mockMvc
                .perform(post("/galaxias/andromeda/planetas/0/sondas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                  {
                                      "x":3,
                                      "y":3,
                                      "sentido":"LESTE"
                                  }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value("3"))
                .andExpect(jsonPath("$.y").value("3"))
                .andExpect(jsonPath("$.sentido").value("LESTE"))
        ;

        // movimenta a sonda
        mockMvc
                .perform(post("/galaxias/andromeda/planetas/0/sondas/1/comandos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""" 
                                { "comandos": "MMRMMRMRRML" }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value("5"))
                .andExpect(jsonPath("$.y").value("1"))
                .andExpect(jsonPath("$.sentido").value("NORTE"))
        ;

        // pega os dados
        mockMvc
                .perform(get("/galaxias/andromeda/planetas/0/sondas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value("5"))
                .andExpect(jsonPath("$.y").value("1"))
                .andExpect(jsonPath("$.sentido").value("NORTE"))
        ;
    }

}
