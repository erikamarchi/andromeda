package com.erikamarchi.andromeda.controller;

import com.erikamarchi.andromeda.model.Planeta;

class PlanetaDto {

    private String nome;
    private Integer id;
    private Integer valorMaximoX, valorMaximoY;

    PlanetaDto(Planeta planeta) {
        this.nome = planeta.getNome();
        this.id = planeta.getId();
        this.valorMaximoX = planeta.getValorMaximoX();
        this.valorMaximoY = planeta.getValorMaximoY();
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public Integer getValorMaximoX() {
        return valorMaximoX;
    }

    public Integer getValorMaximoY() {
        return valorMaximoY;
    }
}
