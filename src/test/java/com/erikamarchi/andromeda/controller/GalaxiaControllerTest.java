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
class GalaxiaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveriaListarAsGalaxias() throws Exception {
        mockMvc
                .perform(get("/galaxias"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value("1"))
                .andExpect(jsonPath("$.[0:1].nome").value("andromeda"))
        ;
    }

    @Test
    void deveriaPegarPeloNomeDaGalaxia() throws Exception {
        mockMvc
                .perform(get("/galaxias/andromeda"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("andromeda"))
        ;
    }

}