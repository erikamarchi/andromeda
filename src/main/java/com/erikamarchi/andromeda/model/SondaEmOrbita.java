package com.erikamarchi.andromeda.model;

public class SondaEmOrbita {
    private Integer x, y;
    private Sonda.Sentido sentido;

    public SondaEmOrbita(Integer x, Integer y, Sonda.Sentido sentido) {
        this.x = x;
        this.y = y;
        this.sentido = sentido;
    }

    public Coordenada getCoordenadas() {
        return new Coordenada(x, y);
    }

    public Sonda.Sentido getSentido(){
        return sentido;
    }

    public void setX(Integer x) {
        this.x = x;
    }


    public void setY(Integer y) {
        this.y = y;
    }


    public void setSentido(Sonda.Sentido sentido) {
        this.sentido = sentido;
    }
}
