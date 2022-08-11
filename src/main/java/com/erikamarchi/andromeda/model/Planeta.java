package com.erikamarchi.andromeda.model;

import com.erikamarchi.andromeda.exception.CoordenadaIndisponivelException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Planeta {

    private String nome;
    private Integer id;
    private Integer valorMaximoX, valorMaximoY;

    private Galaxia galaxia;

    private Map<Integer, Sonda> sondas;

    public Planeta(String nome, Integer id, Integer valorMaximoX, Integer valorMaximoY, Galaxia galaxia) {
        this.nome = nome;
        this.id = id;
        this.valorMaximoX = valorMaximoX;
        this.valorMaximoY = valorMaximoY;
        this.galaxia = galaxia;
        this.sondas = new HashMap<>();
    }

    public Sonda getSondaPorId(Integer idSonda) {
        return sondas.get(idSonda);
    }

    public String getNome() {
        return nome;
    }

    public Galaxia getGalaxia() {
        return galaxia;
    }

    public Integer getId() {
        return id;
    }

    public Integer getValorMaximoX() {
        return valorMaximoX;
    }

    public Integer getValorMaximoY() {
        return valorMaximoY;
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", valorMaximoX=" + valorMaximoX +
                ", valorMaximoY=" + valorMaximoY +
                ", galaxia=" + galaxia +
                '}';
    }

    public Optional<Sonda> getSondaDoPlanetaPorCoordenada(Coordenada coordenada) {
        return sondas
                .values()
                .stream()
                .filter(s -> s.estaNaCoordenada(coordenada))
                .findAny();
    }

    void validarCoordenadaDisponivel(Coordenada coordenada) {
        if (coordenada.getX() > valorMaximoX ||
                coordenada.getY() > valorMaximoY ||
                getSondaDoPlanetaPorCoordenada(coordenada).isPresent()) {
            throw new CoordenadaIndisponivelException(coordenada);
        }
    }

    public Collection<Sonda> getSondas() {
        return sondas.values();
    }

    public void addSonda(Sonda sonda) {
        validarCoordenadaDisponivel(sonda.getCoordenada());
        this.sondas.put(sonda.getId(), sonda);
    }
}
