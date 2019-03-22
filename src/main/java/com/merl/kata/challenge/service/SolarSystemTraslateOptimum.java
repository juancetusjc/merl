package com.merl.kata.challenge.service;

import java.util.List;

import com.merl.kata.challenge.model.ClimaType;
import com.merl.kata.challenge.model.Planet;
import com.merl.kata.challenge.model.SolarSystem;

public class SolarSystemTraslateOptimum extends SolarSystemTraslateStrategy {

	public ClimaType calculateWaither(SolarSystem solarSystem) {
		ClimaType clima = null;
		ordernarDesplazamientos(solarSystem);
		List<Planet> planets = solarSystem.obtainPlanets();

		double x1 =planets.get(0).getPositionX();
		double y1= planets.get(0).getPositionY();
		double x2=planets.get(1).getPositionX();
		double y2=planets.get(1).getPositionY();
		double x3=planets.get(2).getPositionX();
		double y3=planets.get(2).getPositionY();
		
		if (dosPuntosSonColineales(x1,y1,x2,y2,x3,y3)) {
			clima = ClimaType.OPTIMA_DE_PRESION_Y_TEMPERATURA;
		}

		return clima;
	}

	private boolean dosPuntosSonColineales(double x1, double y1, double x2, double y2, double x3, double y3) {
		return (x2-x1)/(x3-x2)==(y2-y1)/(y3-y2);
	}

}
