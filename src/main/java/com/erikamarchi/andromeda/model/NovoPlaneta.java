package com.erikamarchi.andromeda.model;

public class NovoPlaneta {
    private String nome;
    private Integer valorMaximoX;
    private Integer valorMaximoY;
    private Galaxia galaxia;

    public NovoPlaneta(String nome, Integer valorMaximoX, Integer valorMaximoY, Galaxia galaxia) {
        this.nome = nome;
        this.valorMaximoX = valorMaximoX;
        this.valorMaximoY = valorMaximoY;
        this.galaxia = galaxia;
    }

    public Planeta criarPlaneta(Integer id) {
        return new Planeta(nome, id, valorMaximoX, valorMaximoY, galaxia);
    }

}
