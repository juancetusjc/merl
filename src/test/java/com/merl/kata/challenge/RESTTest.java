package com.merl.kata.challenge;

import static org.junit.Assert.fail;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.util.HttpStatus;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.merl.kata.challenge.config.ApplicationConfig;
import com.merl.kata.challenge.domain.Clima;
import com.merl.kata.challenge.logic.ClimaFacade;
import com.merl.kata.challenge.rest.ClimaREST;

@RunWith(Arquillian.class)
public class RESTTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(RESTTest.class);

	@ArquillianResource
	private URL deploymentURL; // el URL donde se desplegó el war

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "vclima-rest.war")
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addClasses(
						ClimaREST.class, 
						ClimaFacade.class,
						ApplicationConfig.class, Clima.class);
	}

	@Test
	@UsingDataSet("datasets/climas.yml")
	public void testFindClima() throws URISyntaxException {
		Client client = createClient();
		WebTarget target = client.target(deploymentURL.toURI()) // registramos el servidor...
				.path("webresources/clima") // .. el path del servicio...
				.queryParam("day", "1"); // ... y los parámetros
		LOGGER.info("--- test find climas:{}", target.getUri());
		Response response = target.request(MediaType.APPLICATION_JSON).get(); // invocamos al servicio por GET
		if (response.getStatus() != HttpStatus.OK_200.getStatusCode()) { // si no es correcto..
			fail("Error :" + response.getStatusInfo().getReasonPhrase()); // .. lanza el error y termina
		}
		// si todo está bien, tratamos de leer el contenido como la lista de pronosticos
		// esperado
		List<Clima> data = response.readEntity(new GenericType<List<Clima>>() {
		});
		Assert.assertFalse(data.isEmpty()); // .. no debería estar vacía la lista.
		data.forEach((p) -> {
			LOGGER.info("\tperiodo:{}", p.getPeriod()); // mostramos el contenido.
		});

	}

	  private static Client createClient() {
	        return ClientBuilder
	                .newBuilder()
	                .register(JacksonJaxbJsonProvider.class) //para procesar las peticiones como JSON
	                .build();
	    }

}
