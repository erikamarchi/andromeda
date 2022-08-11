package com.erikamarchi.andromeda.controller;

import com.erikamarchi.andromeda.exception.ComandoInvalidoException;
import com.erikamarchi.andromeda.model.ComandoMovimentacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class ComandosMovimentacaoDto {

    private static Logger logger = LoggerFactory.getLogger(ComandosMovimentacaoDto.class);

    public String getComandos() {
        return comandos;
    }

    public void setComandos(String comandos) {
        this.comandos = comandos;
    }

    private String comandos;

    List<ComandoMovimentacao> criarComandos() {
        ArrayList<ComandoMovimentacao> comandos = new ArrayList<>();

        for (String c : this.comandos.split("")) {
            try {
                comandos.add(ComandoMovimentacao.valueOf(c));
            } catch (IllegalArgumentException e) {
                logger.error("Comando inválido", e);

                throw new ComandoInvalidoException(
                        String.format("Ah não! O comando %s é inválido :(", c)
                );
            }
        }

        return comandos;
    }

}
