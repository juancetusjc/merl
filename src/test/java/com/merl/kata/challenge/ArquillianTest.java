package com.merl.kata.challenge;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.merl.kata.challenge.domain.Clima;
import com.merl.kata.challenge.logic.ClimaFacade;

@RunWith(Arquillian.class)
public class ArquillianTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArquillianTest.class);

	@Inject
	private ClimaFacade climaFacade;

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "vclima.war")
				// agregando recursos en una ubicación
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				// agregando las clases que se cargarán en el entorno
				.addClasses(ClimaFacade.class, Clima.class);
	}

	

	@Test
	public void testInsertClimas() {
		LOGGER.info("-- Registrando pronosticos");
		// insertando registros en la base de datos
		Clima c1 = climaFacade.create(1, "LLUVIA");
		Clima c2 = climaFacade.create(2, "SEQUIA");
		Clima c3 = climaFacade.create(3, "OPTIMO");

		// averiguando que no sean nulos
		assertNotNull(c1);
		assertNotNull(c2);
		assertNotNull(c3);

		// mostrando en pantalla lo generado
		LOGGER.info("c1:{}", c1);
		LOGGER.info("c2:{}", c2);
		LOGGER.info("c3:{}", c3);
	}

	/*
	@Test
	@UsingDataSet("datasets/climas.yml")
	//@ShouldMatchDataSet("datasets/after_climas.yml")
	public void testClima() {
		LOGGER.info("-- consulta de pronosticos del clima");
		List<Clima> climas = climaFacade.findByPeriod("lluvia");
		assertFalse("Se esperaba al menos un pronostico", climas.isEmpty());

	}
*/
}
