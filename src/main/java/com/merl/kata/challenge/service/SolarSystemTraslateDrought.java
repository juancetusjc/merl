package com.merl.kata.challenge.service;

import java.util.List;

import com.merl.kata.challenge.model.ClimaType;
import com.merl.kata.challenge.model.Planet;
import com.merl.kata.challenge.model.SolarSystem;

public class SolarSystemTraslateDrought extends SolarSystemTraslateStrategy {

	@Override
	public ClimaType calculateWaither(SolarSystem solarSystem) {
		ClimaType clima = null;
		ordernarDesplazamientos(solarSystem);
		List<Planet> planets = solarSystem.obtainPlanets();
		if (todosTienenElMismoDezplazamientoAngular(solarSystem)) {
			clima = ClimaType.SEQUIA;
			return clima;
		}

		boolean esDesplazamiento180=esDiferenciaDeDesplazamiento180Grados(planets.get(0),planets.get(planets.size() - 1));
		if (esDesplazamiento180 && existeSoloDosDesplazamientos(solarSystem)) {
			clima = ClimaType.SEQUIA;
		}
		return clima;
	}
	
	private boolean esDiferenciaDeDesplazamiento180Grados(Planet planetMenorDesplazamiento,Planet planetaMayorDesplazamiento) {
		int mayorDesplazamiento = planetaMayorDesplazamiento.getDesplazamientoAngular();
		int menorDesplazamiento = planetMenorDesplazamiento.getDesplazamientoAngular();
		return (mayorDesplazamiento - menorDesplazamiento == 180);

	}

	private boolean todosTienenElMismoDezplazamientoAngular(SolarSystem solarSystem) {
		List<Planet> planets = solarSystem.obtainPlanets();
		return planets.get(0).getDesplazamientoAngular().intValue() == planets.get(planets.size() - 1)
				.getDesplazamientoAngular().intValue();
	}

	private boolean existeSoloDosDesplazamientos(SolarSystem solarSystem) {
		List<Planet> planets = solarSystem.obtainPlanets();
		int mayorDesplazamiento = planets.get(planets.size() - 1).getDesplazamientoAngular();// this.deveolverElqueTieneMayorDesplazamientoAngular();
		int menorDesplazamiento = planets.get(0).getDesplazamientoAngular();// this.deveolverElqueTieneMenorDesplazamientoAngular();

		for (int i = 1; i < planets.size(); i++) {
			if (planets.get(i).getDesplazamientoAngular().intValue() != menorDesplazamiento
					&& planets.get(i).getDesplazamientoAngular().intValue() != mayorDesplazamiento) {
				return false;
			}
		}
		return true;
	}

}
