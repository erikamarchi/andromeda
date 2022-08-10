package com.erikamarchi.andromeda.model;

public enum ComandoMovimentacao {

    R(){
        @Override
        Localizacao executa(Localizacao localizacao) {
            Sentido novoSentido = localizacao.rotacionarParaDireita();
            return new Localizacao(localizacao.getCoordenada(),novoSentido);
        }
    },
    L(){
        @Override
        Localizacao executa(Localizacao localizacao) {
            Sentido novoSentido = localizacao.rotacionarParaEsquerda();
            return new Localizacao(localizacao.getCoordenada(), novoSentido);
        }
    },
    M(){
        @Override
        Localizacao executa(Localizacao localizacao) {
            Coordenada novaCoordenada = localizacao.recalcularProximaCoordenada();
            return new Localizacao(novaCoordenada, localizacao.getSentido());
        }
    },
    ;
    abstract Localizacao executa(Localizacao localizacao);
}
