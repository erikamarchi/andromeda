package com.erikamarchi.andromeda.dao;

import com.erikamarchi.andromeda.model.NovoPlaneta;
import com.erikamarchi.andromeda.model.Planeta;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PlanetaDao {

    private Map<Integer, Planeta> planetas = new HashMap<>();
    private Integer proximoId = 0;

    public Optional<Planeta> getPlanetaPorID(Integer idPlaneta) {
        return Optional.ofNullable(planetas.get(idPlaneta));
    }

    public Planeta add(NovoPlaneta novoPlaneta) {
        Integer id = proximoId++;
        Planeta planeta = novoPlaneta.criarPlaneta(id);

        planetas.put(id, planeta);

        return planeta;
    }

    public List<Planeta> getPlanetasPelaGalaxia(String nomeDaGalaxia) {
        return planetas
                .values()
                .stream()
                .filter(p -> p.getGalaxia().getNome().equals(nomeDaGalaxia))
                .toList();
    }
}
