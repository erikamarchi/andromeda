package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.model.ComandoMovimentacao;
import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.model.Sonda;
import com.erikamarchi.andromeda.model.SondaEmOrbita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SondaServiceTest {

    private Optional<Planeta> planeta;

    private PlanetaService planetaService = mock(PlanetaService.class);
    private SondaService subject;

    @BeforeEach
    void setup() {
        subject = new SondaService(planetaService);

        planeta = Optional.of(mock(Planeta.class));
        when(planetaService.getPlanetaPorID(1)).thenReturn(planeta);
    }

    @Test
    void deveriaPousarASondaEmOrbita() {
        SondaEmOrbita sondaEmOrbita = mock(SondaEmOrbita.class);

        subject.pousar(1, sondaEmOrbita);

        verify(sondaEmOrbita, only()).pousar(planeta.get());
    }

    @Test
    void deveriaMovimentarASonda() {
        Sonda sonda = mock(Sonda.class);
        ComandoMovimentacao comandoMover = ComandoMovimentacao.M;
        List<ComandoMovimentacao> comandos = List.of(comandoMover);

        when(planeta.get().getSondaPorId(2)).thenReturn(sonda);

        Sonda resposta = subject.movimentar(1, 2, comandos);

        verify(sonda, only()).mover();
        assertEquals(sonda, resposta);
    }

}