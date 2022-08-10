package com.erikamarchi.andromeda.model;

public class Sonda {

    private Integer id;

    private Localizacao localizacao;
    private Planeta planeta;

    public Sonda(Planeta planeta, Integer id, SondaEmOrbita sondaEmOrbita) {
        this.planeta = planeta;
        this.id = id;
        this.localizacao = sondaEmOrbita.getLocalizacao();
    }

    public void movimentar(ComandoMovimentacao acaoMovimento){
        localizacao = acaoMovimento.executa(localizacao);
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public Integer getId() {
        return id;
    }

    public Planeta getPlaneta() {
        return planeta;
    }
}
