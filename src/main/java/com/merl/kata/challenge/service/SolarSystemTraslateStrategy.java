package com.merl.kata.challenge.service;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.merl.kata.challenge.model.ClimaType;
import com.merl.kata.challenge.model.Planet;
import com.merl.kata.challenge.model.SolarSystem;

public  abstract class SolarSystemTraslateStrategy {

	private static final Logger LOGGER = LoggerFactory.getLogger(SolarSystemTraslateStrategy.class);
	private PlanetTraslate planetTraslate= new PlanetTraslate();
	
	public abstract ClimaType calculateWaither(SolarSystem solarSystem) ;
	
	public void ordernarDesplazamientos(SolarSystem solarSystem) {
		List<Planet> planets = solarSystem.obtainPlanets();
		planets.sort(new Comparator<Planet>() {
			public int compare(Planet o1, Planet o2) {
				return o1.getDesplazamientoAngular().compareTo(o2.getDesplazamientoAngular());
			}
		});
	}
	
	public void nextDay(SolarSystem solarSystem) {
		solarSystem.setCurrentDay(solarSystem.getCurrentDay()+1);
		for (Planet planet : solarSystem.obtainPlanets()) {
			planetTraslate.traslate(planet);
			planetTraslate.nextDay(planet);
			planetTraslate.calculatePositionXY(planet);
			LOGGER.info("Day {} - Planet{} - Desplaza:{} Angulo:{} - Ubi X {} Y {} ",solarSystem.getCurrentDay(),planet.getName(),planet.getDesplazamientoAngular(),planet.getAnguloCuadrante(),planet.getPositionX(),planet.getPositionY());
			
		}
		
	}
	public  Planet obtainPlanetReferring(SolarSystem solarSystem) {
		for (Planet planet : solarSystem.obtainPlanets()) {
			if (planet.isReferring()) {
				return planet;
			}
		}
		return null;
	}
	
	
}
