package com.erikamarchi.andromeda.controller;

import com.erikamarchi.andromeda.model.ComandoMovimentacao;
import com.erikamarchi.andromeda.model.Sonda;
import com.erikamarchi.andromeda.service.SondaService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/galaxias/{nomeGalaxia}/planetas/{idPlaneta}/sondas")
public class SondaController {

    private SondaService sondaService;

    public SondaController(SondaService sondaService) {
        this.sondaService = sondaService;
    }

    @PostMapping
    public SondaDto pousar(@PathVariable("idPlaneta") Integer idPlaneta, @RequestBody SondaDto sondaDto) {
        Sonda sondaPousada = sondaService.pousar(idPlaneta, sondaDto.mapperSondaEmOrbita());
        return new SondaDto(sondaPousada);
    }

    @GetMapping(value = "/{idSonda}")
    public SondaDto getSonda(@PathVariable("idPlaneta") Integer idPlaneta, @PathVariable("idSonda") Integer idSonda) {
        return new SondaDto(sondaService.getSondaPorId(idPlaneta, idSonda));
    }

    @GetMapping
    public Collection<SondaDto> getSondas(@PathVariable("idPlaneta") Integer idPlaneta) {
        return sondaService
                .getSondasPorPlaneta(idPlaneta)
                .stream()
                .map(s -> new SondaDto(s))
                .toList();
    }

    @PostMapping(value = "/{idSonda}/comandos")
    public SondaDto movimentar(@PathVariable("idPlaneta") Integer idPlaneta, @PathVariable("idSonda") Integer idSonda, @RequestBody ComandosMovimentacaoDto comandosMovimentacaoDto) {
        List<ComandoMovimentacao> comandoMovimentacoes = comandosMovimentacaoDto.criarComandos();

        Sonda sondaMovimentada = sondaService.movimentar(idPlaneta, idSonda, comandoMovimentacoes);
        return new SondaDto(sondaMovimentada);
    }

}
