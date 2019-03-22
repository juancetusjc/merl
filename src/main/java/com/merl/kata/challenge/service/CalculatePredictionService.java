package com.merl.kata.challenge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.merl.kata.challenge.model.ClimaType;
import com.merl.kata.challenge.model.Planet;
import com.merl.kata.challenge.model.SolarSystem;

public class CalculatePredictionService {

	private SolarSystemTraslateStrategy solarSystemTraslate;
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatePredictionService.class);

	public Integer obtainDroughtPeriod(SolarSystem solarSystem, Integer countYears) {
		solarSystemTraslate = new SolarSystemTraslateDrought();
		Integer counterDroughtPeriod = 0;
		Planet planet = solarSystemTraslate.obtainPlanetReferring(solarSystem);
		Integer allDays = planet.obtainDaysForYear() * countYears;

		for (Integer day = 0; day < allDays; day++) {
			ClimaType clima = solarSystemTraslate.calculateWaither(solarSystem);
			if (clima != null && clima.equals(ClimaType.SEQUIA)) {
				counterDroughtPeriod++;
			}
			solarSystemTraslate.nextDay(solarSystem);
		}
		return counterDroughtPeriod;
	}

	public Integer obtainRainPeriod(SolarSystem solarSystem, Integer countYears) {
		solarSystemTraslate = new SolarSystemTraslateRain();
		Integer counterRainPeriod = 0;
		Planet planet = solarSystemTraslate.obtainPlanetReferring(solarSystem);
		Integer allDays = planet.obtainDaysForYear() * countYears;

		for (Integer day = 0; day < allDays; day++) {
			ClimaType clima = solarSystemTraslate.calculateWaither(solarSystem);
			if (clima != null && clima.equals(ClimaType.LLUVIA)) {
				LOGGER.info("clima:{}", "LLUVIA");
				counterRainPeriod++;
			}
			solarSystemTraslate.nextDay(solarSystem);// .nextDay();
		}
		return counterRainPeriod;
	}

	public Integer obtainOptimumPeriod(SolarSystem solarSystem, Integer countYears) {
		solarSystemTraslate = new SolarSystemTraslateOptimum();
		Integer counterRainPeriod = 0;
		Planet planet = solarSystemTraslate.obtainPlanetReferring(solarSystem);
		Integer allDays = planet.obtainDaysForYear() * countYears;
		for (Integer day = 0; day < allDays; day++) {
			ClimaType clima = solarSystemTraslate.calculateWaither(solarSystem);
			if (clima != null && clima.equals(ClimaType.OPTIMA_DE_PRESION_Y_TEMPERATURA)) {
				LOGGER.info("clima:{}", "OPTIMA_DE_PRESION_Y_TEMPERATURA");
				counterRainPeriod++;
			}
			solarSystemTraslate.nextDay(solarSystem);// .nextDay();
		}
		return counterRainPeriod;
	}

}
