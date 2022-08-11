package com.erikamarchi.andromeda.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ComandoMovimentacaoTest {

    @Test
    void quandoComandoForRVerificaRotacionaDireita() {
        Localizacao localizacao = mock(Localizacao.class);

        when(localizacao.rotacionarParaDireita()).thenReturn(Sentido.NORTE);

        Localizacao resposta = ComandoMovimentacao.R.executa(localizacao);

        assertNotNull(resposta);
        assertEquals(Sentido.NORTE, resposta.getSentido());
    }

    @Test
    void quandoComandoForLVerificaRotacionaEsquerda() {
        Localizacao localizacao = mock(Localizacao.class);

        when(localizacao.rotacionarParaEsquerda()).thenReturn(Sentido.NORTE);

        Localizacao resposta = ComandoMovimentacao.L.executa(localizacao);

        assertNotNull(resposta);
        assertEquals(Sentido.NORTE, resposta.getSentido());
    }

    @Test
    void quandoComandoForMRecalculaProximaCoordenada() {
        Localizacao localizacao = mock(Localizacao.class);
        Coordenada coordenada = mock(Coordenada.class);

        when(localizacao.recalcularProximaCoordenada()).thenReturn(coordenada);

        Localizacao resposta = ComandoMovimentacao.M.executa(localizacao);

        assertNotNull(resposta);
        assertEquals(coordenada, resposta.getCoordenada());
    }
}