package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.dao.SondaDao;
import com.erikamarchi.andromeda.model.ComandoMovimentacao;
import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.model.Sonda;
import com.erikamarchi.andromeda.model.SondaEmOrbita;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SondaService {

    private SondaDao sondaDao;
    private PlanetaService planetaService;

    private ValidadorCoordenada validadorCoordenada;

    public SondaService(SondaDao sondaDao, PlanetaService planetaService, ValidadorCoordenada validadorCoordenada) {
        this.sondaDao = sondaDao;
        this.planetaService = planetaService;
        this.validadorCoordenada = validadorCoordenada;
    }

    public Sonda pousar(Integer idPlaneta, SondaEmOrbita sondaEmOrbita) {
        Planeta planeta = planetaService.getPlanetaPorID(idPlaneta);
        planeta.validarCoordenadaDisponivel(validadorCoordenada, sondaEmOrbita.getCoordenada());
        return sondaDao.addSonda(sondaEmOrbita, planeta);
    }

    public Sonda movimentar(Integer idSonda, List<ComandoMovimentacao> comandoMovimentacoes) {
        Sonda sonda = this.sondaDao.getSondaPorId(idSonda);

        for (ComandoMovimentacao comandoMovimento : comandoMovimentacoes) {
            sonda.movimentar(comandoMovimento, validadorCoordenada);
        }
        return sonda;
    }

    public Sonda getSondaPorId(Integer idSonda) {
        return this.sondaDao.getSondaPorId(idSonda);
    }

    public Collection<Sonda> getSondasPorPlaneta(Integer idPlaneta) {
        return this.sondaDao.getSondasPorPlaneta(idPlaneta);
    }
}
