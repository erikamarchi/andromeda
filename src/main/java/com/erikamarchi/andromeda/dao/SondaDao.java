package com.erikamarchi.andromeda.dao;

import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.model.Sonda;
import com.erikamarchi.andromeda.model.SondaEmOrbita;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SondaDao {

    private Integer proximoId = 0;
    private Map<Integer, Sonda> sondas = new HashMap<>();

    public Sonda addSonda(SondaEmOrbita sondaEmOrbita, Planeta planeta) {
        Integer id = proximoId++;
        Sonda sonda = new Sonda(planeta, id, sondaEmOrbita);
        sondas.put(id, sonda);

        return sonda;
    }

    public Sonda getSondaPorId(Integer idSonda) {
        return this.sondas.get(idSonda);
    }

    public Collection<Sonda> getSondasPorPlaneta(Integer planetaId) {
        return sondas
                .values()
                .stream()
                .filter(s -> s.getPlaneta().getId().equals(planetaId))
                .toList();
    }

    public Collection<Sonda> getSondasPorGalaxia(String nomeDaGalaxia) {
        return sondas
                .values()
                .stream()
                .filter(s -> s.getPlaneta().getGalaxia().getNome().equals(nomeDaGalaxia))
                .toList();
    }
}
