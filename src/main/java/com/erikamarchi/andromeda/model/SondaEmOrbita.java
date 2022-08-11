package com.erikamarchi.andromeda.model;

public class SondaEmOrbita {
    private Localizacao localizacao;


    public SondaEmOrbita(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Localizacao getLocalizacao(){

        return localizacao;
    }

    public Coordenada getCoordenada (){
        return localizacao.getCoordenada();
    }

}
