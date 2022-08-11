package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.dao.SondaDao;
import com.erikamarchi.andromeda.model.Coordenada;
import com.erikamarchi.andromeda.model.Sonda;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidadorCoordenadaTest {

    private SondaDao sondaDao = mock(SondaDao.class);
    private Coordenada coordenada = mock(Coordenada.class);

    @Test
    void deveResponderQueUmaPosicaoNaoEstaDisponivelQuandoExisteUmaSondaNaCoordenada() {
        Optional<Sonda> optionalSonda = Optional.of(mock(Sonda.class));

        when(sondaDao.getSondaDoPlanetaPorCoordenada(1, coordenada)).thenReturn(optionalSonda);

        ValidadorCoordenada validadorCoordenada = new ValidadorCoordenada(sondaDao);

        Boolean resposta = validadorCoordenada.validaCoordenadaOcupada(1, coordenada);
        assertTrue(resposta);
    }

    @Test
    void deveResponderQueUmaPosicaoEstaDisponivelQuandoNaoExisteUmaSondaNaCoordenada() {
        Optional<Sonda> optionalSonda = Optional.empty();

        when(sondaDao.getSondaDoPlanetaPorCoordenada(1, coordenada)).thenReturn(optionalSonda);

        ValidadorCoordenada validadorCoordenada = new ValidadorCoordenada(sondaDao);

        Boolean resposta = validadorCoordenada.validaCoordenadaOcupada(1, coordenada);
        assertFalse(resposta);
    }

}