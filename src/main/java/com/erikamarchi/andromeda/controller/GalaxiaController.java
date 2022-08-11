package com.erikamarchi.andromeda.controller;

import com.erikamarchi.andromeda.model.Galaxia;
import com.erikamarchi.andromeda.service.GalaxiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/galaxias")
public class GalaxiaController {

    private GalaxiaService galaxiaService;

    public GalaxiaController(GalaxiaService galaxiaService) {
        this.galaxiaService = galaxiaService;
    }

    @GetMapping
    public Collection<GalaxiaDto> getGalaxias() {
        return galaxiaService
                .getGalaxias()
                .stream().map(g -> new GalaxiaDto(g))
                .toList();
    }

    @GetMapping(value = "/{nomeGalaxia}")
    public ResponseEntity<GalaxiaDto> getGalaxia(@PathVariable("nomeGalaxia") String nomeGalaxia) {
        Optional<Galaxia> galaxia = galaxiaService.getGalaxiaPorNome(nomeGalaxia);
        return galaxia
                .map(g -> new GalaxiaDto(g))
                .map(dto -> ResponseEntity.ok(dto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
