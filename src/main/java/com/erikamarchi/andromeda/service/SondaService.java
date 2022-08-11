package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.model.ComandoMovimentacao;
import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.model.Sonda;
import com.erikamarchi.andromeda.model.SondaEmOrbita;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SondaService {

    private PlanetaService planetaService;

    public SondaService(PlanetaService planetaService) {
        this.planetaService = planetaService;
    }

    public Sonda pousar(Integer idPlaneta, SondaEmOrbita sondaEmOrbita) {
        Planeta planeta = planetaService.getPlanetaPorID(idPlaneta);

        return sondaEmOrbita.pousar(planeta);
    }

    public Sonda movimentar(Integer idPlaneta, Integer idSonda, List<ComandoMovimentacao> comandoMovimentacoes) {
        Sonda sonda = getSondaPorId(idPlaneta, idSonda);

        for (ComandoMovimentacao comandoMovimento : comandoMovimentacoes) {
            comandoMovimento.executa(sonda);
        }
        return sonda;
    }

    public Sonda getSondaPorId(Integer idPlaneta, Integer idSonda) {
        return planetaService.getPlanetaPorID(idPlaneta).getSondaPorId(idSonda);
    }

    public Collection<Sonda> getSondasPorPlaneta(Integer idPlaneta) {
        return planetaService.getPlanetaPorID(idPlaneta).getSondas();
    }
}
