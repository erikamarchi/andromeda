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

    public Coordenada recalcularProximaCoordenada(){
        return sentido.recalcularProximaCoordenada(coordenada);
    }

    public Sentido rotacionarParaEsquerda(){
        return sentido.rotacionarEsquerda();
    }

    public Sentido rotacionarParaDireita(){
        return sentido.rotacionarDireita();
    }
}
