package com.erikamarchi.andromeda.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class SentidoTest {


    @Test
    void norteDeveriaMandarSubirCoordenda() {
        Coordenada coordenada = mock(Coordenada.class);

        Sentido.NORTE.recalcularProximaCoordenada(coordenada);

        verify(coordenada, only()).subir();
    }

    @Test
    void sulDeveriaMandarDescerCoordenda() {
        Coordenada coordenada = mock(Coordenada.class);

        Sentido.SUL.recalcularProximaCoordenada(coordenada);

        verify(coordenada, only()).descer();
    }

    @Test
    void lesteDeveriaMandarDeslocarParaDireitaCoordenda() {
        Coordenada coordenada = mock(Coordenada.class);

        Sentido.LESTE.recalcularProximaCoordenada(coordenada);

        verify(coordenada, only()).deslocarParaDireita();
    }

    @Test
    void oesteDeveriaMandarDeslocarParaEsquerdaCoordenda() {
        Coordenada coordenada = mock(Coordenada.class);

        Sentido.OESTE.recalcularProximaCoordenada(coordenada);

        verify(coordenada, only()).deslocarParaEsquerda();
    }

    @Test
    void quandoNorteRotacionarEsquerdaDeveriaSerOeste() {
        Sentido resposta = Sentido.NORTE.rotacionarEsquerda();

        assertEquals(Sentido.OESTE, resposta);
    }

    @Test
    void quandoOesteRotacionarEsquerdaDeveriaSerSul() {
        Sentido resposta = Sentido.OESTE.rotacionarEsquerda();

        assertEquals(Sentido.SUL, resposta);
    }

    @Test
    void quandoSulRotacionarEsquerdaDeveriaSerLeste() {
        Sentido resposta = Sentido.SUL.rotacionarEsquerda();

        assertEquals(Sentido.LESTE, resposta);
    }

    @Test
    void quandoLesteRotacionarEsquerdaDeveriaSerNorte() {
        Sentido resposta = Sentido.LESTE.rotacionarEsquerda();

        assertEquals(Sentido.NORTE, resposta);
    }

    @Test
    void quandoNorteRotacionarDireitaDeveriaSerLeste() {
        Sentido resposta = Sentido.NORTE.rotacionarDireita();

        assertEquals(Sentido.LESTE, resposta);
    }

    @Test
    void quandoLesteRotacionarDireitaDeveriaSerSul() {
        Sentido resposta = Sentido.LESTE.rotacionarDireita();

        assertEquals(Sentido.SUL, resposta);
    }

    @Test
    void quandoSulRotacionarDireitaDeveriaSerOeste() {
        Sentido resposta = Sentido.SUL.rotacionarDireita();

        assertEquals(Sentido.OESTE, resposta);
    }

    @Test
    void quandoOesteRotacionarDireitaDeveriaSerNorte() {
        Sentido resposta = Sentido.OESTE.rotacionarDireita();

        assertEquals(Sentido.NORTE, resposta);
    }

}