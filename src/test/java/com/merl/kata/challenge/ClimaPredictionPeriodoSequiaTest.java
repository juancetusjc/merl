package com.merl.kata.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.merl.kata.challenge.model.ClimaType;
import com.merl.kata.challenge.model.Planet;
import com.merl.kata.challenge.model.SolarSystem;
import com.merl.kata.challenge.model.TurnType;
import com.merl.kata.challenge.service.PlanetTraslate;
import com.merl.kata.challenge.service.SolarSystemTraslateDrought;

public class ClimaPredictionPeriodoSequiaTest {

	// Premisas:
	// Se asumen que el dia 0 los 3 planetas se encuentran alineado.
	// El clima afecta a todos los planetas del sistema solar por igual. Es decir no
	// importa la distancia de cada planeta al sol
	private SolarSystemTraslateDrought solarSystemTraslate = new SolarSystemTraslateDrought();
	private PlanetTraslate planetTraslate= new PlanetTraslate();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void calcularDesplazamientoDiaUnoPlanetaVulcano() {

		Planet planetaVulcano = new Planet();
		planetaVulcano.asingPositionInitialToCreation(0);
		planetaVulcano.setDias(1);
		planetaVulcano.setVelocity(5);
		planetaVulcano.setRadius(1000);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.nextDay(planetaVulcano);
		Assert.assertEquals(Integer.valueOf(5), planetaVulcano.getDesplazamientoFinal());

	}

	@Test
	public void calcularClimaSinDesplazamientoAngular() {
		SolarSystem solarSystem = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(0);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		solarSystem.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(0);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		
		solarSystem.addPlanet(planetaVulcano);
		
		
		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(0);
		planetaFerengi.setTurn(TurnType.CLOCK);
		solarSystem.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.SEQUIA, solarSystemTraslate.calculateWaither(solarSystem));

	}

	@Test
	public void calcularClimaConDesplazamientoAngularDe360() {
		SolarSystem solarSystem = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(360);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		solarSystem.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(360);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		solarSystem.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(360);
		planetaFerengi.setTurn(TurnType.CLOCK);
		solarSystem.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.SEQUIA, solarSystemTraslate.calculateWaither(solarSystem));

	}

	@Test
	public void calcularClimaAlineadosEnElPrimerCuadrante() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(45);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(315);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(45);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);
		
		Assert.assertEquals(ClimaType.SEQUIA, solarSystemTraslate.calculateWaither(sistemaSolar));

	}

	@Test
	public void calcularClimaAlineadosEnElPrimerCuadrante90Grados() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(90);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(270);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(90);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.SEQUIA, solarSystemTraslate.calculateWaither(sistemaSolar));

	}

	@Test
	public void calcularClimaAlineadosEnElSegundoCuadrante() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(135);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(225);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(135);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.SEQUIA, solarSystemTraslate.calculateWaither(sistemaSolar));

	}

	@Test
	public void calcularClimaAlineadosEnElTererCuadrante() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(225);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(135);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(225);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.SEQUIA, solarSystemTraslate.calculateWaither(sistemaSolar));

	}

	@Test
	public void calcularClimaAlineadosEnElCuartoCuadrante() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(315);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(45);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(315);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.SEQUIA, solarSystemTraslate.calculateWaither(sistemaSolar));

	}

	@Test
	public void calcularClimaAlineadosEnDiferentesCuadrantePlanetasHorariosYAntiHorarioPrimerCuadrante() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(45);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(135);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(45);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.SEQUIA, solarSystemTraslate.calculateWaither(sistemaSolar));

	}

	@Test
	public void calcularClimaAlineadosEnDiferentesCuadrantePlanetasHorariosYAntiHorarioSegundoCuadrante() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(135);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(45);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(135);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);

		Assert.assertEquals(ClimaType.SEQUIA, solarSystemTraslate.calculateWaither(sistemaSolar));

	}

	@Test
	public void calcularClimaAlineadosEnDiferentesCuadrantePlanetasHorariosYAntiHorarioTercerCuadrante() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(225);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(315);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(225);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);
		Assert.assertEquals(ClimaType.SEQUIA, solarSystemTraslate.calculateWaither(sistemaSolar));
	}

	@Test
	public void calcularClimaSoloMinioyMaximoDesplazamientosAlineados() {
		SolarSystem sistemaSolar = new SolarSystem();

		Planet planetaBetasoide = new Planet();
		planetaBetasoide.setDesplazamientoAngular(45);
		planetaBetasoide.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaBetasoide);

		Planet planetaVulcano = new Planet();
		planetaVulcano.setDesplazamientoAngular(135);
		planetaVulcano.setTurn(TurnType.ANTI_CLOCK);
		planetTraslate.traslate(planetaVulcano);
		sistemaSolar.addPlanet(planetaVulcano);

		Planet planetaFerengi = new Planet();
		planetaFerengi.setDesplazamientoAngular(180);
		planetaFerengi.setTurn(TurnType.CLOCK);
		sistemaSolar.addPlanet(planetaFerengi);
		Assert.assertEquals(null, solarSystemTraslate.calculateWaither(sistemaSolar));
	}
}
