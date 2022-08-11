package com.erikamarchi.andromeda.model;

import com.erikamarchi.andromeda.exception.CoordenadaIndisponivelException;
import com.erikamarchi.andromeda.service.ValidadorCoordenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class PlanetaTest {

    private Galaxia galaxia = mock(Galaxia.class);
    private ValidadorCoordenada validadorCoordenada = mock(ValidadorCoordenada.class);
    private Planeta subject;

    @BeforeEach
    void setup() {
        subject = new Planeta("meu planeta", 10, 1, 5, galaxia);
    }

    @Test
    void deveriaPermitirACoordenadaQuandoAPosicaoEstaLivreEDentroDosLimites() {
        Coordenada coordenada = new Coordenada(1, 5);
        when(validadorCoordenada.validaCoordenadaOcupada(10,coordenada)).thenReturn(false);

        subject.validarCoordenadaDisponivel(validadorCoordenada, coordenada);

        verify(validadorCoordenada, only()).validaCoordenadaOcupada(10, coordenada);
    }

    @Test
    void naoDeveriaPermitirACoordenadaForaDoLimiteX() {
        Coordenada coordenada = new Coordenada(2, 5);
        when(validadorCoordenada.validaCoordenadaOcupada(10,coordenada)).thenReturn(false);

        assertThatThrownBy(() -> subject.validarCoordenadaDisponivel(validadorCoordenada, coordenada))
                .isInstanceOf(CoordenadaIndisponivelException.class);
    }

    @Test
    void naoDeveriaPermitirACoordenadaForaDoLimiteY() {
        Coordenada coordenada = new Coordenada(0, 6);
        when(validadorCoordenada.validaCoordenadaOcupada(10,coordenada)).thenReturn(false);

        assertThatThrownBy(() -> subject.validarCoordenadaDisponivel(validadorCoordenada, coordenada))
                .isInstanceOf(CoordenadaIndisponivelException.class);
    }

    @Test
    void naoDeveriaPermitirACoordenadaQuandoNaoEstiverDisponivel() {
        Coordenada coordenada = new Coordenada(0, 1);
        when(validadorCoordenada.validaCoordenadaOcupada(10,coordenada)).thenReturn(true);

        assertThatThrownBy(() -> subject.validarCoordenadaDisponivel(validadorCoordenada, coordenada))
                .isInstanceOf(CoordenadaIndisponivelException.class);
    }

}