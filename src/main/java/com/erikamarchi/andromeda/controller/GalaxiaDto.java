package com.erikamarchi.andromeda.controller;

import com.erikamarchi.andromeda.model.Galaxia;

class GalaxiaDto {

    private String nome;
    public GalaxiaDto(Galaxia galaxia) {
        this.nome = galaxia.getNome();
    }

    public String getNome() {
        return nome;
    }
}
