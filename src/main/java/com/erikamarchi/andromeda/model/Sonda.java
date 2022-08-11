package com.erikamarchi.andromeda.model;

import com.erikamarchi.andromeda.service.ValidadorCoordenada;

public class Sonda {

    private Integer id;

    private Localizacao localizacao;
    private Planeta planeta;

    public Sonda(Planeta planeta, Integer id, SondaEmOrbita sondaEmOrbita) {
        this.planeta = planeta;
        this.id = id;
        this.localizacao = sondaEmOrbita.getLocalizacao();
    }

    public void movimentar(ComandoMovimentacao comandoMovimentacao, ValidadorCoordenada validadorCoordenada) {
        Localizacao proximaLocalizacao = comandoMovimentacao.executa(localizacao);
        planeta.validarCoordenadaDisponivel(validadorCoordenada, proximaLocalizacao.getCoordenada());
        this.localizacao = proximaLocalizacao;
    }

    public void mover(ValidadorCoordenada validadorCoordenada) {
        Coordenada proximaCoordenada = localizacao.recalcularProximaCoordenada();
        planeta.validarCoordenadaDisponivel(validadorCoordenada, proximaCoordenada);
//        this.localizacao = new Localizacao(proximaCoordenada, )
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
}
