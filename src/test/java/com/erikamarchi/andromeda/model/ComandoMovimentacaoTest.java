package com.erikamarchi.andromeda.model;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ComandoMovimentacaoTest {

    @Test
    void quandoComandoForRVerificaRotacionaDireita() {
        Sonda sonda = mock(Sonda.class);

        ComandoMovimentacao.R.executa(sonda);

        verify(sonda, only()).rotacionarParaDireita();
    }

    @Test
    void quandoComandoForLVerificaRotacionaEsquerda() {
        Sonda sonda = mock(Sonda.class);

        ComandoMovimentacao.L.executa(sonda);

        verify(sonda, only()).rotacionarParaEsquerda();
    }

    @Test
    void quandoComandoForMRecalculaProximaCoordenada() {
        Sonda sonda = mock(Sonda.class);

        ComandoMovimentacao.M.executa(sonda);

        verify(sonda, only()).mover();
    }
}