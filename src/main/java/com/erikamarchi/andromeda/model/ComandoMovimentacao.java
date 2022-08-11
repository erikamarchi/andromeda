package com.erikamarchi.andromeda.model;

public enum ComandoMovimentacao {

    R() {
        @Override
        public void executa(Sonda sonda) {
            sonda.rotacionarParaDireita();
        }
    },
    L() {
        @Override
        public void executa(Sonda sonda) {
            sonda.rotacionarParaEsquerda();
        }
    },
    M() {
        @Override
        public void executa(Sonda sonda) {
            sonda.mover();
        }
    },
    ;

    public abstract void executa(Sonda sonda);
}
