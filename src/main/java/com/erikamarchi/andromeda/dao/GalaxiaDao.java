package com.erikamarchi.andromeda.dao;

import com.erikamarchi.andromeda.model.Galaxia;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GalaxiaDao {

    private Map<String, Galaxia> galaxias;

    public GalaxiaDao() {
        this.galaxias = new HashMap<>();
    }

    public void addGalaxia(Galaxia galaxia) {
        galaxias.put(galaxia.getNome(), galaxia);
    }

    public Galaxia getGalaxiaPorNome(String nome) {
        return galaxias.get(nome);
    }

    public Collection<Galaxia> getGalaxias() {
        return galaxias.values();
    }
}
