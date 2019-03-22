package com.merl.kata.challenge.schedule;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.merl.kata.challenge.logic.ClimaFacade;
import com.merl.kata.challenge.model.ClimaType;
import com.merl.kata.challenge.model.Planet;
import com.merl.kata.challenge.model.SolarSystem;
import com.merl.kata.challenge.model.TurnType;
import com.merl.kata.challenge.service.CalculatePredictionService;
import com.merl.kata.challenge.service.SolarSystemTraslateDrought;
import com.merl.kata.challenge.service.SolarSystemTraslateOptimum;
import com.merl.kata.challenge.service.SolarSystemTraslateRain;
import com.merl.kata.challenge.service.SolarSystemTraslateStrategy;
import com.merl.kata.challenge.util.Constants;

@Stateless
public class CalculatorPredictionSchedule {

	SolarSystem solarSystem = new SolarSystem();
	CalculatePredictionService calculatorPrediction = new CalculatePredictionService();
	SolarSystemTraslateStrategy solarSystemTraslateDrought = new SolarSystemTraslateDrought();
	SolarSystemTraslateStrategy solarSystemTraslateRain = new SolarSystemTraslateRain();
	SolarSystemTraslateStrategy solarSystemTraslateOptimum = new SolarSystemTraslateOptimum();

	@Inject
	private ClimaFacade climaFacade;

	public void initSchedule() {

		Planet ferengiPlanet = new Planet();
		ferengiPlanet.setName("Ferengi");
		ferengiPlanet.setTurn(TurnType.CLOCK);
		ferengiPlanet.setVelocity(1);
		ferengiPlanet.setRadius(500);// km
		ferengiPlanet.asingPositionInitialToCreation(0);
		ferengiPlanet.setReferring(Boolean.TRUE);
		solarSystem.addPlanet(ferengiPlanet);

		Planet betasoidePlanet = new Planet();
		betasoidePlanet.setName("Betasoide");
		betasoidePlanet.setTurn(TurnType.CLOCK);
		betasoidePlanet.setVelocity(3);
		betasoidePlanet.setRadius(2000);// Km
		betasoidePlanet.asingPositionInitialToCreation(0);
		// betasoidePlanet.setReferring(Boolean.TRUE);
		solarSystem.addPlanet(betasoidePlanet);

		Planet vulcanPlanet = new Planet();
		vulcanPlanet.setName("Vulcano");
		vulcanPlanet.setTurn(TurnType.ANTI_CLOCK);
		vulcanPlanet.setVelocity(5);
		vulcanPlanet.setRadius(1000);// km
		vulcanPlanet.asingPositionInitialToCreation(0);
		// vulcanPlanet.setReferring(Boolean.TRUE);
		solarSystem.addPlanet(vulcanPlanet);

	}

//	@Schedule(second = "*/50", minute = "*", hour = "*") // Thirty second intervals
	public void calculatePrediction(Integer year) {
		if (solarSystem.obtainPlanets().isEmpty()) {
			initSchedule();
		}
		
		Integer limitYear =year==null?Constants.COUNT_YEAR:year;

		Planet planet = solarSystemTraslateDrought.obtainPlanetReferring(solarSystem);
		Integer allDays = planet.obtainDaysForYear() * limitYear;

		for (Integer day = 0; day < allDays; day++) {
			if (climaFacade.findByDay(day) == null) {
				ClimaType clima = solarSystemTraslateDrought.calculateWaither(solarSystem);
				
				if (clima == null)
					clima = solarSystemTraslateRain.calculateWaither(solarSystem);

				if (clima == null)
					clima = solarSystemTraslateOptimum.calculateWaither(solarSystem);

				if (clima != null) {
					climaFacade.create(day, clima.toString());
				}

			}

			solarSystemTraslateDrought.nextDay(solarSystem);// .nextDay();
		}
		calculatorPrediction.obtainDroughtPeriod(solarSystem, 10);
	}
}
