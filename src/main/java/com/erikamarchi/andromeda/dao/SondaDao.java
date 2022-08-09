package com.erikamarchi.andromeda.dao;

import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.model.Sonda;
import com.erikamarchi.andromeda.model.SondaEmOrbita;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SondaDao {

    private Integer proximoId = 0;
    private List<Sonda> sondas = new ArrayList<>();

    public Sonda addSonda(SondaEmOrbita sondaEmOrbita, Planeta planeta) {
        Sonda sonda = new Sonda(planeta,proximoId++,sondaEmOrbita);
        sondas.add(sonda);

        return sonda;
    }

    public Sonda getSondaPorId(Integer idSonda) {
        return this.sondas.get(idSonda);
    }
}
