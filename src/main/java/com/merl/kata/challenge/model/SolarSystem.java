package com.merl.kata.challenge.model;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {

	private List<Planet> planets = new ArrayList<Planet>();
	private ClimaType clima = ClimaType.NINGUNO;
	private Long perimetroTrianguloPlanetas;
	private Integer currentDay = 0;
	
	
	public void addPlanet(Planet planeta) {
		planets.add(planeta);
	}

	public List<Planet> obtainPlanets() {
		return planets;
	}


	public ClimaType getClima() {
		return clima;
	}

	public void setClima(ClimaType clima) {
		this.clima = clima;
	}

	public Long getPerimetroTrianguloPlanetas() {
		return perimetroTrianguloPlanetas;
	}

	public void setPerimetroTrianguloPlanetas(Long perimetroTrianguloPlanetas) {
		this.perimetroTrianguloPlanetas = perimetroTrianguloPlanetas;
	}

	public void calcularPerimetro() {
		for (Planet planeta : planets) {
			this.perimetroTrianguloPlanetas = this.perimetroTrianguloPlanetas + planeta.getRadius();
		}
	}


	public Integer getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(Integer currentDay) {
		this.currentDay = currentDay;
	}

	public String currentPosition() {
		return String.format("Position day %s: %s[ %s ] - %s[ %s ] %s[ %s ]", currentDay,
				planets.get(0).getName(),planets.get(0).getDesplazamientoAngular(), planets.get(1).getName(),planets.get(1).getDesplazamientoAngular(),
				planets.get(2).getName(),planets.get(2).getDesplazamientoAngular());

	}

}
