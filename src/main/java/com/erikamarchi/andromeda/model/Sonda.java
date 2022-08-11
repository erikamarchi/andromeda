package com.erikamarchi.andromeda.model;

public class Sonda {

    private Integer id;

    private Localizacao localizacao;
    private Planeta planeta;

    Sonda(Planeta planeta, Integer id, SondaEmOrbita sondaEmOrbita) {
        this.planeta = planeta;
        this.id = id;
        this.localizacao = sondaEmOrbita.getLocalizacao();
    }

    public void mover() {
        Localizacao proximaLocalizacao = localizacao.recalcularProximaCoordenada();
        planeta.validarCoordenadaDisponivel(proximaLocalizacao.getCoordenada());
        this.localizacao = proximaLocalizacao;
    }

    public void rotacionarParaEsquerda() {
        this.localizacao = localizacao.rotacionarParaEsquerda();
    }

    public void rotacionarParaDireita() {
        this.localizacao = localizacao.rotacionarParaDireita();
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

    public Boolean estaNaCoordenada(Coordenada coordenada) {
        return this.localizacao.getCoordenada().equals(coordenada);
    }

    public Coordenada getCoordenada() {
        return this.localizacao.getCoordenada();
    }
}
