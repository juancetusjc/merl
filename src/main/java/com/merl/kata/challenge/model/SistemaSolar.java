package com.merl.kata.challenge.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaSolar {
	private List<Planeta> planetas= new ArrayList<Planeta>();
	private ClimaType clima;
	
	public void agregarPlaneta(Planeta planeta) {
		planetas.add(planeta);
	}

	public void calcularClima() {
		
	}

	public ClimaType getClima() {
		return clima;
	}

	public void setClima(ClimaType clima) {
		this.clima = clima;
	}
}
