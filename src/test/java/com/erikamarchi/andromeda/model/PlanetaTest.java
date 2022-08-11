package com.erikamarchi.andromeda.model;

import com.erikamarchi.andromeda.exception.CoordenadaIndisponivelException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlanetaTest {

    private Galaxia galaxia = mock(Galaxia.class);
    private Planeta subject;

    @BeforeEach
    void setup() {
        subject = new Planeta("meu planeta", 10, 1, 5, galaxia);
    }

    @Test
    void deveriaPermitirAdicionarNumLocalDisponivel() {
        Coordenada coordenada = new Coordenada(1, 2);
        subject.validarCoordenadaDisponivel(coordenada);
    }

    @Test
    void naoDeveriaPermitirAdicionarNumLocalOcupado() {
        Coordenada coordenada = new Coordenada(1, 5);
        Sonda sonda = mock(Sonda.class);
        when(sonda.getCoordenada()).thenReturn(coordenada);
        when(sonda.estaNaCoordenada(coordenada)).thenReturn(true);

        // ocupar o local
        subject.addSonda(sonda);

        assertThatThrownBy(() -> subject.addSonda(sonda))
                .isInstanceOf(CoordenadaIndisponivelException.class);
    }

    @Test
    void aCoordenadaDeveSerIndisponivelQuandoEstiverForaDoLimiteX() {
        Coordenada coordenada = new Coordenada(2, 5);

        assertThatThrownBy(() -> subject.validarCoordenadaDisponivel(coordenada))
                .isInstanceOf(CoordenadaIndisponivelException.class);
    }

    @Test
    void aCoordenadaDeveSerIndisponivelQuandoEstiverForaDoLimitey() {
        Coordenada coordenada = new Coordenada(1, 6);

        assertThatThrownBy(() -> subject.validarCoordenadaDisponivel(coordenada))
                .isInstanceOf(CoordenadaIndisponivelException.class);
    }

}