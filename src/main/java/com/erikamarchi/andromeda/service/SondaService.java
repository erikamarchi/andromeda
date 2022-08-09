package com.erikamarchi.andromeda.service;

import com.erikamarchi.andromeda.dao.PlanetaDao;
import com.erikamarchi.andromeda.dao.SondaDao;
import com.erikamarchi.andromeda.model.AcaoMovimentacao;
import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.model.Sonda;
import com.erikamarchi.andromeda.model.SondaEmOrbita;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SondaService {

    private PlanetaDao planetaDao;
    private SondaDao sondaDao;

    public SondaService(PlanetaDao planetaDao, SondaDao sondaDao) {
        this.planetaDao = planetaDao;
        this.sondaDao = sondaDao;
    }

    public Sonda pousar (Integer idPlaneta, SondaEmOrbita sondaEmOrbita){
        //TODO Validar se pode pode pousar na coordenada recebida

        Planeta planeta = planetaDao.getPlanetaPorID(idPlaneta);
        Sonda sonda = sondaDao.addSonda(sondaEmOrbita, planeta);

        planeta.addSonda(sonda);


        return sonda;
    }

    public void movimentar (Integer idSonda, List<AcaoMovimentacao> acoesMovimentacao){

        Sonda sonda = this.sondaDao.getSondaPorId(idSonda);

        for(AcaoMovimentacao acaoMovimento : acoesMovimentacao){
            sonda.movimentar(acaoMovimento);
        }
    }
}
