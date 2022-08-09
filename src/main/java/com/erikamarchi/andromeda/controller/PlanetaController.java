package com.erikamarchi.andromeda.controller;

import com.erikamarchi.andromeda.model.Galaxia;
import com.erikamarchi.andromeda.model.Planeta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/galaxias/andromeda")
public class PlanetaController {

	private Galaxia galaxia;

	public PlanetaController(Galaxia galaxia){
		this.galaxia = galaxia;
	}

	@GetMapping
	public Galaxia getGalaxia() {
		return galaxia;
	}

	@GetMapping (value = "/planetas")
	public List<Planeta> getPlanetas(){
		return galaxia.getPlanetas();
	}

}
