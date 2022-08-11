package com.erikamarchi.andromeda.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlanetaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveriaListarOsPlanetas() throws Exception {
        mockMvc
                .perform(get("/galaxias/andromeda/planetas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value("5"))
        ;
    }

    @Test
    void deveriaPegarPeloIdDoPlaneta() throws Exception {
        mockMvc
                .perform(get("/galaxias/andromeda/planetas/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valorMaximoX").value("5"))
                .andExpect(jsonPath("$.valorMaximoY").value("5"))
        ;
    }

}