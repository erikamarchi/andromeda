package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.dao.SondaDao;
import com.erikamarchi.andromeda.model.Coordenada;
import com.erikamarchi.andromeda.model.Sonda;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidadorCoordenada {

    private SondaDao sondaDao;

    public ValidadorCoordenada(SondaDao sondaDao) {
        this.sondaDao = sondaDao;
    }

    public Boolean validaCoordenadaOcupada(Integer idPlaneta, Coordenada coordenada) {
        Optional<Sonda> sondaNaCoordenada = sondaDao.getSondaDoPlanetaPorCoordenada(idPlaneta, coordenada);

        return sondaNaCoordenada.isPresent();
    }
}
