package com.erikamarchi.andromeda.controller;

import com.erikamarchi.andromeda.exception.ComandoInvalidoException;
import com.erikamarchi.andromeda.model.ComandoMovimentacao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ComandosMovimentacaoDtoTest {

    private ComandosMovimentacaoDto subject;

    @Test
    void verificaSeCriaListaComandosMovimentacao() {
        subject = new ComandosMovimentacaoDto();
        subject.setComandos("LRM");

        List<ComandoMovimentacao> resposta = subject.criarComandos();

        assertEquals(3, resposta.size());
        assertEquals(ComandoMovimentacao.L, resposta.get(0));
        assertEquals(ComandoMovimentacao.R, resposta.get(1));
        assertEquals(ComandoMovimentacao.M, resposta.get(2));
    }

    @Test
    void verificaSeLancaExcecaoComandoInvalido() {
        subject = new ComandosMovimentacaoDto();
        subject.setComandos("t");

        assertThatThrownBy(() -> subject.criarComandos())
                .isInstanceOf(ComandoInvalidoException.class)
                .hasMessage("Ah não! O comando t é inválido :(");
    }
}