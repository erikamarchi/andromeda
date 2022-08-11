package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.exception.PousoException;
import com.erikamarchi.andromeda.model.ComandoMovimentacao;
import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.model.Sonda;
import com.erikamarchi.andromeda.model.SondaEmOrbita;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SondaService {

    private PlanetaService planetaService;

    public SondaService(PlanetaService planetaService) {
        this.planetaService = planetaService;
    }

    public Sonda pousar(Integer idPlaneta, SondaEmOrbita sondaEmOrbita) {
        Planeta planeta = planetaService
                .getPlanetaPorID(idPlaneta)
                .orElseThrow(() -> new PousoException(String.format("Oh não! Esse planeta %s não existe", idPlaneta)));

        return sondaEmOrbita.pousar(planeta);
    }

    public Sonda movimentar(Integer idPlaneta, Integer idSonda, List<ComandoMovimentacao> comandoMovimentacoes) {
        Sonda sonda = getSondaPorId(idPlaneta, idSonda)
                .orElseThrow(() -> new PousoException(String.format("Oh não! Esse planeta %s não existe ou a sonda %s não existe", idPlaneta, idSonda)));

        for (ComandoMovimentacao comandoMovimento : comandoMovimentacoes) {
            comandoMovimento.executa(sonda);
        }
        return sonda;
    }

    public Optional<Sonda> getSondaPorId(Integer idPlaneta, Integer idSonda) {
        return planetaService
                .getPlanetaPorID(idPlaneta)
                .map(p -> p.getSondaPorId(idSonda));
    }

    public Collection<Sonda> getSondasPorPlaneta(Integer idPlaneta) {
        return planetaService
                .getPlanetaPorID(idPlaneta)
                .map(p -> p.getSondas())
                .orElseGet(() -> Collections.emptyList());
    }
}
