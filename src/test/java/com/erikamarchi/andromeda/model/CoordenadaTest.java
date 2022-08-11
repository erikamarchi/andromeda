package com.erikamarchi.andromeda.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordenadaTest {

    @Test
    void deveriaSubir() {
        Coordenada coordenada = new Coordenada(1,2);
        Coordenada resposta = coordenada.subir();

        assertEquals(3,resposta.getY());
        assertEquals(1,resposta.getX());
    }

    @Test
    void deveriaDescer() {
        Coordenada coordenada = new Coordenada(2,5);
        Coordenada resposta = coordenada.descer();

        assertEquals(4,resposta.getY());
        assertEquals(2,resposta.getX());
    }

    @Test
    void deveriaDeslocarParaEsquerda() {
        Coordenada coordenada = new Coordenada(1,2);
        Coordenada resposta = coordenada.deslocarParaEsquerda();

        assertEquals(2,resposta.getY());
        assertEquals(0,resposta.getX());
    }

    @Test
    void deveriaDeslocarParaDireita() {
        Coordenada coordenada = new Coordenada(3,1);
        Coordenada resposta = coordenada.deslocarParaDireita();

        assertEquals(1,resposta.getY());
        assertEquals(4,resposta.getX());
    }
}