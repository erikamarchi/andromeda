package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.dao.PlanetaDao;
import com.erikamarchi.andromeda.model.NovoPlaneta;
import com.erikamarchi.andromeda.model.Planeta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetaService {

    private PlanetaDao planetaDao;

    public PlanetaService(PlanetaDao planetaDao) {
        this.planetaDao = planetaDao;
    }

    public Planeta addPlaneta(NovoPlaneta novoPlaneta) {
        return this.planetaDao.add(novoPlaneta);
    }

    public Optional<Planeta> getPlanetaPorID(Integer id) {
        return planetaDao.getPlanetaPorID(id);
    }

    public List<Planeta> getPlanetasPelaGalaxia(String nomeDaGalaxia) {
        return this.planetaDao.getPlanetasPelaGalaxia(nomeDaGalaxia);
    }

    public Integer quantidadePlanetasDaGalaxia(String nomeDaGalaxia) {
        return planetaDao.getPlanetasPelaGalaxia(nomeDaGalaxia).size();
    }

}
