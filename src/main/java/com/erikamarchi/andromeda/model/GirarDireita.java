//package com.erikamarchi.andromeda.model;
//
//public class GirarDireita implements ComandoMovimentacao {
//
//    @Override
//    public Localizacao executa(Localizacao localizacao) {
//        Integer x1 = localizacao.getCoordenada().getX();
//        Integer y1 = localizacao.getCoordenada().getY();
//
//        Double x = (x1 * Math.cos(Sentido.ANGULO_MOVIMENTACAO)) -
//                    (y1 * Math.sin(Sentido.ANGULO_MOVIMENTACAO));
//
//        Double y = (y1 * Math.cos(Sentido.ANGULO_MOVIMENTACAO)) +
//                    (x * Math.sin(Sentido.ANGULO_MOVIMENTACAO));
//
//        Coordenada novaCoordenada = new Coordenada(x.intValue(),y.intValue());
//
//        Sentido novoSentido = localizacao.getSentido().girarADireita();
//
//        return new Localizacao(novaCoordenada, novoSentido);
//    }
//}
