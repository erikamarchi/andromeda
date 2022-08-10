package com.erikamarchi.andromeda.model;

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

//	// TODO  lançar execeção de erro
//	public void addSonda(Sonda sonda) {
//		if (valorMaximoX * valorMaximoY <= this.sondas.size()) {
//			this.sondas.add(sonda);
//		}
//	}

	public String getNome() {
		return nome;
	}

//	public Sonda getSonda(int id) {
//		return this.sondas.get(id);
//	}
//
//	public List<Sonda> getSondas(){
//		return this.sondas;
//	}

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
}
