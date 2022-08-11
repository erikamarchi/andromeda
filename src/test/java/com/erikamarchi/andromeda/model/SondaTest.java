package com.erikamarchi.andromeda.model;

import com.erikamarchi.andromeda.service.ValidadorCoordenada;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SondaTest {

    @Test
    public void verificaSeExisteValidacaoNaHoraDeMoverASonda() {
        Planeta planeta = mock(Planeta.class);
        SondaEmOrbita sondaEmOrbita = mock(SondaEmOrbita.class);
        Localizacao localizacaoAtual = mock(Localizacao.class);
        ValidadorCoordenada validadorCoordenada = mock(ValidadorCoordenada.class);
        Coordenada proximaCoordenada = mock(Coordenada.class);

        when(localizacaoAtual.recalcularProximaCoordenada()).thenReturn(proximaCoordenada);
        when(sondaEmOrbita.getLocalizacao()).thenReturn(localizacaoAtual);

        Sonda subject = new Sonda(planeta, 1, sondaEmOrbita);

        subject.movimentar(ComandoMovimentacao.M, validadorCoordenada);

        verify(planeta, only()).validarCoordenadaDisponivel(validadorCoordenada, proximaCoordenada);
    }

}