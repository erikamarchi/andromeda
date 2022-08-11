package com.erikamarchi.andromeda.model;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SondaTest {

    @Test
    public void verificaSeExisteValidacaoNaHoraDeMoverASonda() {
        Planeta planeta = mock(Planeta.class);
        SondaEmOrbita sondaEmOrbita = mock(SondaEmOrbita.class);
        Localizacao localizacaoAtual = mock(Localizacao.class);
        Localizacao proximaLocalizacao = mock(Localizacao.class);
        Coordenada proximaCoordenada = mock(Coordenada.class);

        when(sondaEmOrbita.getLocalizacao()).thenReturn(localizacaoAtual);
        when(localizacaoAtual.recalcularProximaCoordenada()).thenReturn(proximaLocalizacao);
        when(proximaLocalizacao.getCoordenada()).thenReturn(proximaCoordenada);

        Sonda subject = new Sonda(planeta, 1, sondaEmOrbita);

        subject.mover();

        verify(planeta, only()).validarCoordenadaDisponivel(proximaCoordenada);
    }

}