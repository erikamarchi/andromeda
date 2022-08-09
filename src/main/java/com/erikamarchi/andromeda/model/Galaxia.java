package com.erikamarchi.andromeda.model;

import java.util.ArrayList;
import java.util.List;

public class Galaxia {

	private String nome;	
	
	private List<Planeta> planetas;

	public Galaxia(String nome) {
		this.nome = nome;
		planetas = new ArrayList<>();
	}
	
	public void addPlaneta (Planeta planeta) {
		this.planetas.add(planeta);
	}
	
	public String getNome() {
		return nome;
	}

	public Planeta getPlaneta(int id) {
		return planetas.get(id);
	}

	public List<Planeta> getPlanetas(){
		return this.planetas;
	}

	public Integer quantidadePlanetas(){
		return planetas.size();
	}

}
