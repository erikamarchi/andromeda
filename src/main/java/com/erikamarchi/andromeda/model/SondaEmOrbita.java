package com.erikamarchi.andromeda.model;

public class SondaEmOrbita {

    private static Integer idSequencialSonda = 0;
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

    public Sonda pousar(Planeta planeta) {
        Sonda sonda = new Sonda(planeta, idSequencialSonda++, this);
        planeta.addSonda(sonda);
        return sonda;
    }

}
