package com.erikamarchi.andromeda.controller;

import com.erikamarchi.andromeda.model.*;

public class SondaDto {
    private Integer id, x, y;
    private Sentido sentido;

    public SondaDto() {
    }

    public SondaDto(Sonda sonda) {
        this.id = sonda.getId();
        this.x = sonda.getLocalizacao().getCoordenada().getX();
        this.y = sonda.getLocalizacao().getCoordenada().getY();
        this.sentido = sonda.getLocalizacao().getSentido();
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Sentido getSentido() {
        return sentido;
    }

    public void setSentido(Sentido sentido) {
        this.sentido = sentido;
    }

    public Integer getId() {
        return id;
    }

    public SondaEmOrbita mapperSondaEmOrbita() {

        Coordenada coordenada = new Coordenada(x, y);
        Localizacao localizacao = new Localizacao(coordenada, sentido);

        return new SondaEmOrbita(localizacao);
    }

}
