package com.merl.kata.challenge;

import org.junit.Assert;
import org.junit.Test;

import com.merl.kata.challenge.model.ClimaType;
import com.merl.kata.challenge.model.Planet;
import com.merl.kata.challenge.model.SolarSystem;
import com.merl.kata.challenge.model.TurnType;
import com.merl.kata.challenge.service.PlanetTraslate;
import com.merl.kata.challenge.service.SolarSystemTraslateRain;

public class ClimaPredictionPeriodoLluviaTest {

	private SolarSystemTraslateRain solarSystemTraslate = new SolarSystemTraslateRain();
	private PlanetTraslate planetTraslate= new PlanetTraslate();
	
	@Test
	public void calcularPeriodoLluviaDesplazamientoMinimo() {
		SolarSystem sistemaSolar = new SolarSystem();
		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(0);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(0);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(0);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(null, solarSystemTraslate.calculateWaither(sistemaSolar));
	}

	@Test
	public void calcularPeriodoLluviaDesplazamientoSinLLuvia() {
		SolarSystem sistemaSolar = new SolarSystem();
		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(45);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(179);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(91);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(null, solarSystemTraslate.calculateWaither(sistemaSolar));
	}

	@Test
	public void calcularPeriodoLluviaDesplazamientoExtremos() {
		SolarSystem sistemaSolar = new SolarSystem();
		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(0);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(1);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(90);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);


		Assert.assertEquals(null, solarSystemTraslate.calculateWaither(sistemaSolar));
		Assert.assertEquals(sistemaSolar.getClima(), ClimaType.NINGUNO);
	}

	@Test
	public void calcularClimaLluviaEnOrdenPrimeroSegundoYTercero() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(25);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(135);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(95);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.LLUVIA, solarSystemTraslate.calculateWaither(sistemaSolar));
	}

	@Test
	public void calcularClimaLluviaEnOrdenSegundoTerceroYCuarto() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(95);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(15);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(230);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.LLUVIA, solarSystemTraslate.calculateWaither(sistemaSolar));

	}

	@Test
	public void calcularClimaLluviaEnOrdenTerceroCuartoYPrimero() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(190);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(300);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(330);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.LLUVIA, solarSystemTraslate.calculateWaither(sistemaSolar));


	}
}
