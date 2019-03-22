package com.merl.kata.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.merl.kata.challenge.model.Planet;
import com.merl.kata.challenge.model.SolarSystem;
import com.merl.kata.challenge.model.TurnType;
import com.merl.kata.challenge.service.CalculatePredictionService;

public class ClimaPredictionAllConditionTest {

	SolarSystem solarSystem = new SolarSystem();
	CalculatePredictionService calculatorPrediction = new CalculatePredictionService();
	private static final Logger LOGGER = LoggerFactory.getLogger(ClimaPredictionAllConditionTest.class);
	
	@Before
	public void setUp() {

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

	@Test
	public void calcularPeriodoDeSequiaPor10AniosPlanetaVulcano() {
		Assert.assertNotNull(calculatorPrediction.obtainDroughtPeriod(solarSystem, 1));
	}

	@Test
	public void calculatePeriodRainFor10Years() {
		CalculatePredictionService calculatorPrediction = new CalculatePredictionService();

		Assert.assertNotNull(calculatorPrediction.obtainRainPeriod(solarSystem, 10));
	}
	@Test
	public void calcularPeriodoOptimoPor10AniosPlanetaVulcano() {
		Assert.assertNotNull(calculatorPrediction.obtainOptimumPeriod(solarSystem, 10));
	}
}
