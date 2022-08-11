package com.erikamarchi.andromeda.model;

import java.util.Arrays;

public enum Sentido {
    NORTE(Math.toRadians(90)) {
        @Override
        public Coordenada recalcularProximaCoordenada(Coordenada coordenada) {
            return coordenada.subir();
        }

        @Override
        public Sentido rotacionarEsquerda() {

            return Sentido.OESTE;
        }

        @Override
        public Sentido rotacionarDireita() {
            return Sentido.LESTE;
        }

    },
    SUL(Math.toRadians(270)) {
        @Override
        public Coordenada recalcularProximaCoordenada(Coordenada coordenada) {
            return coordenada.descer();
        }

        @Override
        public Sentido rotacionarEsquerda() {

            return Sentido.LESTE;
        }

        @Override
        public Sentido rotacionarDireita() {
            return Sentido.OESTE;
        }
    },
    LESTE(Math.toRadians(0.0)) {
        @Override
        public Coordenada recalcularProximaCoordenada(Coordenada coordenada) {
            return coordenada.deslocarParaDireita();
        }

        @Override
        public Sentido rotacionarEsquerda() {

            return Sentido.NORTE;
        }

        @Override
        public Sentido rotacionarDireita() {
            return Sentido.SUL;
        }
    },
    OESTE(Math.toRadians(180)) {
        @Override
        public Coordenada recalcularProximaCoordenada(Coordenada coordenada) {
            return coordenada.deslocarParaEsquerda();
        }

        @Override
        public Sentido rotacionarEsquerda() {

            return Sentido.SUL;
        }

        @Override
        public Sentido rotacionarDireita() {
            return Sentido.NORTE;
        }
    },
    ;

    public static final Double ANGULO_MOVIMENTACAO = Math.toRadians(90);

    private final Double angulo;

    Sentido(Double angulo) {
        this.angulo = angulo;
    }

    public abstract Coordenada recalcularProximaCoordenada(Coordenada coordenada);

    public abstract Sentido rotacionarEsquerda();

    public abstract Sentido rotacionarDireita();

}