package com.erikamarchi.andromeda.dao;

import com.erikamarchi.andromeda.model.Planeta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlanetaDao {

    private Integer proximoId = 0;
    private List<Planeta> planetas = new ArrayList<>();


    public Planeta getPlanetaPorID(Integer idPlaneta) {
        return planetas.get(idPlaneta);
    }

    public Planeta add(String nome, int valorMaximoX, int valorMaximoY) {
        Planeta planeta = new Planeta(nome,proximoId++, valorMaximoX,valorMaximoY);

        planetas.add(planeta);

        return planeta;
    }
}
