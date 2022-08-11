package com.erikamarchi.andromeda.controller;

import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.service.PlanetaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/galaxias/{nomeGalaxia}/planetas")
public class PlanetaController {

    private PlanetaService planetaService;

    public PlanetaController(PlanetaService planetaService) {
        this.planetaService = planetaService;
    }

    @GetMapping
    public List<PlanetaDto> getPlanetas(@PathVariable("nomeGalaxia") String nomeGalaxia) {
        return planetaService
                .getPlanetasPelaGalaxia(nomeGalaxia)
                .stream()
                .map(p -> new PlanetaDto(p))
                .toList();
    }

    @GetMapping(value = "/{idPlaneta}")
    public ResponseEntity<PlanetaDto> getPlanetaPorId(
            @PathVariable("idPlaneta") Integer idPlaneta
    ) {
        Optional<Planeta> planeta = planetaService.getPlanetaPorID(idPlaneta);
        return planeta
                .map(p -> new PlanetaDto(p))
                .map(dto -> ResponseEntity.ok(dto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
