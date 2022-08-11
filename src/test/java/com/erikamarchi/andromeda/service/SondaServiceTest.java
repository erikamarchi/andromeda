package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.dao.SondaDao;
import com.erikamarchi.andromeda.model.ComandoMovimentacao;
import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.model.Sonda;
import com.erikamarchi.andromeda.model.SondaEmOrbita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SondaServiceTest {

    private SondaDao sondaDao = mock(SondaDao.class);
    private PlanetaService planetaService = mock(PlanetaService.class);
    private ValidadorCoordenada validadorCoordenada = mock(ValidadorCoordenada.class);
    private SondaService subject;

    @BeforeEach
    void setup() {
        subject = new SondaService(sondaDao, planetaService, validadorCoordenada);
    }

    @Test
    void deveriaValidarEPousarASondaEmOrbita() {
        SondaEmOrbita sondaEmOrbita = mock(SondaEmOrbita.class);
        Planeta planeta = mock(Planeta.class);
        when(planetaService.getPlanetaPorID(1)).thenReturn(planeta);

        subject.pousar(1, sondaEmOrbita);

        verify(planeta, only()).validarCoordenadaDisponivel(validadorCoordenada, sondaEmOrbita.getCoordenada());
        verify(sondaDao, only()).addSonda(sondaEmOrbita, planeta);
    }

    @Test
    void deveriaMovimentarASonda() {
        Sonda sonda = mock(Sonda.class);
        ComandoMovimentacao comandoMover = ComandoMovimentacao.M;
        List<ComandoMovimentacao> comandos = List.of(comandoMover);

        when(sondaDao.getSondaPorId(2)).thenReturn(sonda);

        Sonda resposta = subject.movimentar(2, comandos);

        verify(sonda, only()).movimentar(comandoMover, validadorCoordenada);
        assertEquals(sonda, resposta);
    }

}