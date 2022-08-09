package com.erikamarchi.andromeda.factory;

import com.erikamarchi.andromeda.dao.PlanetaDao;
import com.erikamarchi.andromeda.model.Galaxia;
import com.erikamarchi.andromeda.model.Planeta;
import com.erikamarchi.andromeda.util.NomeAleatorio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PequenoBigBangFactory {

	private PlanetaDao planetaDao;

	public PequenoBigBangFactory(PlanetaDao planetaDao) {
		this.planetaDao = planetaDao;
	}

	@Bean
	public Galaxia iniciaBigBang() {
		Galaxia galaxia = new Galaxia("andromeda");

		int larguraMaxima = 5;
		int comprimentoMaximo = 5;

		NomeAleatorio nomeAleatorio = new NomeAleatorio();

		while (galaxia.quantidadePlanetas() <= 5) {
			Planeta planeta = planetaDao.add(nomeAleatorio.criaNomeAleatorio(), larguraMaxima, comprimentoMaximo);
			galaxia.addPlaneta(planeta);
		}

		return galaxia;
	}



}
