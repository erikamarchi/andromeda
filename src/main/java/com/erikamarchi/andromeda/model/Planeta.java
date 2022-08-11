package com.erikamarchi.andromeda.model;

import com.erikamarchi.andromeda.exception.CoordenadaIndisponivelException;
import com.erikamarchi.andromeda.service.ValidadorCoordenada;

public class Planeta {

    private String nome;
    private Integer id;
    private Integer valorMaximoX, valorMaximoY;

    private Galaxia galaxia;

    public Planeta(String nome, Integer id, Integer valorMaximoX, Integer valorMaximoY, Galaxia galaxia) {
        this.nome = nome;
        this.id = id;
        this.valorMaximoX = valorMaximoX;
        this.valorMaximoY = valorMaximoY;
        this.galaxia = galaxia;
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

    public void validarCoordenadaDisponivel(ValidadorCoordenada validadorCoordenada, Coordenada coordenada) {
        if (coordenada.getX() > valorMaximoX ||
                coordenada.getY() > valorMaximoY ||
                validadorCoordenada.validaCoordenadaOcupada(id, coordenada)) {
            throw new CoordenadaIndisponivelException(coordenada);
        }
    }
}
