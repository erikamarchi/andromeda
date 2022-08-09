package com.erikamarchi.andromeda.model;

import java.util.ArrayList;
import java.util.List;

public class Planeta {

	private String nome;
	private int id;
	private List<Sonda> sondas;
	private int valorMaximoX, valorMaximoY;

	public Planeta(String nome, int id, int valorMaximoX, int valorMaximoY) {
		this.nome = nome;
		this.id = id;
		this.valorMaximoX = valorMaximoX;
		this.valorMaximoY = valorMaximoY;
		
		sondas = new ArrayList<>();
	}

	public int quantidadeSondasPousadas() {
		return this.sondas.size();
	}

	// TODO  lançar execeção de erro
	public void addSonda(Sonda sonda) {
		if (valorMaximoX * valorMaximoY <= this.sondas.size()) {
			this.sondas.add(sonda);
		}
	}

	public String getNome() {
		return nome;
	}

	public Sonda getSonda(int id) {
		return this.sondas.get(id);
	}

	public List<Sonda> getSondas(){
		return this.sondas;
	}

	public String toString() {
		return "Planeta " +
				this.nome +
				"\nQuantidade de sondas pousadas: " +
				this.quantidadeSondasPousadas();
	}
}
