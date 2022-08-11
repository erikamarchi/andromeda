package com.erikamarchi.andromeda.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SondaEmOrbitaTest {

    @Test
    void deveriaPousarUmaSondaEmOrbita() {
        Localizacao localizacao = mock(Localizacao.class);
        Planeta planeta = mock(Planeta.class);

        SondaEmOrbita subject = new SondaEmOrbita(localizacao);

        Sonda resposta = subject.pousar(planeta);

        assertNotNull(resposta);
        verify(planeta, only()).addSonda(resposta);
    }

}