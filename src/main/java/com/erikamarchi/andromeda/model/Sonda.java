package com.erikamarchi.andromeda.model;

public class Sonda {

    private Integer id;
    public enum Sentido {
        NORTE, SUL, LESTE, OESTE
    }


    private Coordenada coordenada;
    private Sentido sentido;

    private Planeta planeta;

    public Sonda(Planeta planeta, Integer id, SondaEmOrbita sondaEmOrbita) {
        this.planeta = planeta;
        this.id = id;
        this.coordenada = sondaEmOrbita.getCoordenadas();
        this.sentido = sondaEmOrbita.getSentido();
    }

    public void movimentar(AcaoMovimentacao acaoMovimento){
        acaoMovimento.executa(this);
    }

}
