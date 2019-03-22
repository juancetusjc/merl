package com.merl.kata.challenge.service;

import java.util.List;

import com.merl.kata.challenge.model.ClimaType;
import com.merl.kata.challenge.model.Planet;
import com.merl.kata.challenge.model.SolarSystem;

public class SolarSystemTraslateRain extends SolarSystemTraslateStrategy {

	public ClimaType calculateWaitherv1(SolarSystem solarSystem) {
		ClimaType clima = null;
		ordernarDesplazamientos(solarSystem);
		List<Planet> planets = solarSystem.obtainPlanets();
		int mayorDesplazamiento = planets.get(planets.size() - 1).getDesplazamientoAngular();
		int menorDesplazamiento = planets.get(0).getDesplazamientoAngular();

		boolean cumpleCondicion = true;
		for (int i = 1; i < planets.size(); i++) {
			if (diferenciaDeRerroridosMenorDe180Grados(planets.get(i - 1), planets.get(i))) {
				cumpleCondicion = false;
			}
		}

		if (cumpleCondicion && (mayorDesplazamiento - menorDesplazamiento > 180)) {
			clima = ClimaType.LLUVIA;
		}

		return clima;
	}
	public ClimaType calculateWaither(SolarSystem solarSystem) {
		ClimaType clima = null;
		ordernarDesplazamientos(solarSystem);
		List<Planet> planets = solarSystem.obtainPlanets();
		int mayorDesplazamiento = planets.get(planets.size() - 1).getDesplazamientoAngular();
		int menorDesplazamiento = planets.get(0).getDesplazamientoAngular();
		
		boolean cumpleCondicion = true;
		for (int i = 1; i < planets.size(); i++) {
			if (diferenciaDeRerroridosMenorDe180Grados(planets.get(i - 1), planets.get(i))) {
				cumpleCondicion = false;
			}
		}

		if (cumpleCondicion && (mayorDesplazamiento - menorDesplazamiento > 180)) {
			clima = ClimaType.LLUVIA;
		}

		return clima;
	}
	
	private boolean diferenciaDeRerroridosMenorDe180Grados(Planet planetaMenorRecorrido, Planet planetaMayorRecorrido) {
		int recorridoMenor = planetaMenorRecorrido.getDesplazamientoAngular().intValue();
		int recorridoMayor = planetaMayorRecorrido.getDesplazamientoAngular().intValue();
		return (recorridoMayor - recorridoMenor >= 180);
	}

}
