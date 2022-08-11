package com.erikamarchi.andromeda.model;

public class Localizacao {
    private Coordenada coordenada;
    private Sentido sentido;

    public Localizacao(Coordenada coordenada, Sentido sentido) {
        this.coordenada = coordenada;
        this.sentido = sentido;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public Sentido getSentido() {
        return sentido;
    }

    public Localizacao recalcularProximaCoordenada() {
        return new Localizacao(sentido.recalcularProximaCoordenada(coordenada), sentido);
    }

    public Localizacao rotacionarParaEsquerda() {
        return new Localizacao(coordenada, sentido.rotacionarEsquerda());
    }

    public Localizacao rotacionarParaDireita() {
        return new Localizacao(coordenada, sentido.rotacionarDireita());
    }
}
