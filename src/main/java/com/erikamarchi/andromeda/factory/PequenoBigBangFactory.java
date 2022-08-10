package com.erikamarchi.andromeda.factory;

import com.erikamarchi.andromeda.model.Galaxia;
import com.erikamarchi.andromeda.model.NovoPlaneta;
import com.erikamarchi.andromeda.service.GalaxiaService;
import com.erikamarchi.andromeda.service.PlanetaService;
import com.erikamarchi.andromeda.util.NomeAleatorio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PequenoBigBangFactory implements CommandLineRunner {

    private GalaxiaService galaxiaService;
    private PlanetaService planetaService;
    private NomeAleatorio nomeAleatorio;
    private Integer larguraMaxima;
    private Integer comprimentoMaximo;
    private String nomeDaGalaxia;

    public PequenoBigBangFactory(
            GalaxiaService galaxiaService,
            PlanetaService planetaService,
            NomeAleatorio nomeAleatorio,
            @Value("${larguraMaxima}") Integer larguraMaxima,
            @Value("${comprimentoMaximo}") Integer comprimentoMaximo,
            @Value("${nomeDaGalaxia}") String nomeDaGalaxia
    ) {
        this.galaxiaService = galaxiaService;
        this.planetaService = planetaService;
        this.nomeAleatorio = nomeAleatorio;
        this.larguraMaxima = larguraMaxima;
        this.comprimentoMaximo = comprimentoMaximo;
        this.nomeDaGalaxia = nomeDaGalaxia;
    }

    @Override
    public void run(String... args) {
        Galaxia galaxia = new Galaxia(nomeDaGalaxia);
        galaxiaService.addGalaxia(galaxia);

        for (int i = 0; i < 5; i++) {
            NovoPlaneta novoPlaneta = new NovoPlaneta(nomeAleatorio.criaNomeAleatorio(), larguraMaxima, comprimentoMaximo, galaxia);
            planetaService.addPlaneta(novoPlaneta);
        }

    }
}
