package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.dao.GalaxiaDao;
import com.erikamarchi.andromeda.model.Galaxia;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GalaxiaService {

    private GalaxiaDao galaxiaDao;

    public GalaxiaService(GalaxiaDao galaxiaDao) {
        this.galaxiaDao = galaxiaDao;
    }

    public Galaxia getGalaxiaPorNome(String nome) {
        return galaxiaDao.getGalaxiaPorNome(nome);
    }

    public Collection<Galaxia> getGalaxias() {
        return galaxiaDao.getGalaxias();
    }

    public void addGalaxia(Galaxia galaxia) {
        galaxiaDao.addGalaxia(galaxia);
    }

}
