package com.merl.kata.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.merl.kata.challenge.model.ClimaType;
import com.merl.kata.challenge.model.GiroType;
import com.merl.kata.challenge.model.Planeta;
import com.merl.kata.challenge.model.SistemaSolar;

public class ClimaPredictionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void calcularClimaDiaCero() {
		SistemaSolar sistemaSolar = new SistemaSolar();

		Planeta planetaVulcano = new Planeta();
		planetaVulcano.setDesplazamientoInicial(0);
		planetaVulcano.setDias(0);
		planetaVulcano.setDistanciaAlSol(1000);// Kilometros
		planetaVulcano.setSentidoGiro(GiroType.ANTI_HORARIO);
		planetaVulcano.calcularDesplazamiento();
		sistemaSolar.agregarPlaneta(planetaVulcano);

		Planeta planetaFerengi = new Planeta();
		planetaFerengi.setDesplazamientoInicial(0);
		planetaFerengi.setDias(0);
		planetaFerengi.setDistanciaAlSol(500);// Kilometros
		planetaFerengi.setSentidoGiro(GiroType.HORARIO);
		planetaFerengi.calcularDesplazamiento();
		sistemaSolar.agregarPlaneta(planetaFerengi);

		Planeta planetaBetasoide = new Planeta();
		planetaBetasoide.setDesplazamientoInicial(0);
		planetaBetasoide.setDias(0);
		planetaBetasoide.setDistanciaAlSol(2000);
		planetaBetasoide.setSentidoGiro(GiroType.HORARIO);
		planetaBetasoide.calcularDesplazamiento();
		sistemaSolar.agregarPlaneta(planetaBetasoide);

		sistemaSolar.calcularClima();

		Assert.assertEquals(sistemaSolar.getClima(), ClimaType.SEQUIA);

	}

	// Premisas:
	// Se asumen que el dia 0 los 3 planetas se encuentran alineado.
	// El clima afecta a todos los planetas del sistema solar por igual. Es decir no
	// importa la distancia de cada planeta al sol

}
