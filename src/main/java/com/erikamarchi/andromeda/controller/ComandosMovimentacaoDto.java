package com.erikamarchi.andromeda.controller;

import com.erikamarchi.andromeda.model.ComandoMovimentacao;

import java.util.ArrayList;
import java.util.List;

class ComandosMovimentacaoDto {

    public String getComandos() {
        return comandos;
    }

    public void setComandos(String comandos) {
        this.comandos = comandos;
    }

    private String comandos;

    List<ComandoMovimentacao> criarComandos() {
        ArrayList<ComandoMovimentacao> comandos = new ArrayList<>();
        for (String c: this.comandos.split("")) {
            comandos.add(ComandoMovimentacao.valueOf(c));
        }
        return comandos;
    }

}
