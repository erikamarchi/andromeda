package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.dao.SondaDao;
import com.erikamarchi.andromeda.model.ComandoMovimentacao;
import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.model.Sonda;
import com.erikamarchi.andromeda.model.SondaEmOrbita;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.List;

@Service
public class SondaService {

    private SondaDao sondaDao;
    private PlanetaService planetaService;

    public SondaService(SondaDao sondaDao, PlanetaService planetaService) {
        this.sondaDao = sondaDao;
        this.planetaService = planetaService;
    }

    public Sonda pousar(Integer idPlaneta, SondaEmOrbita sondaEmOrbita) {
        //TODO Validar se pode pode pousar na coordenada recebida
        Planeta planeta = planetaService.getPlanetaPorID(idPlaneta);
        return sondaDao.addSonda(sondaEmOrbita, planeta);
    }

    public Sonda movimentar(Integer idSonda, List<ComandoMovimentacao> comandoMovimentacoes) {
        //TODO validar se pode realizar o movimento
        Sonda sonda = this.sondaDao.getSondaPorId(idSonda);

        for (ComandoMovimentacao comandoMovimento : comandoMovimentacoes) {
            sonda.movimentar(comandoMovimento);
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
