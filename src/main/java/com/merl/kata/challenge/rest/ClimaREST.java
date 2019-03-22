package com.merl.kata.challenge.rest;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.merl.kata.challenge.domain.Clima;
import com.merl.kata.challenge.logic.ClimaFacade;

@Path("clima")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class ClimaREST {

	@Inject
	private ClimaFacade facade; 

	@GET
	public Clima findByDay(@QueryParam("day") Integer day) {
		Clima clima=facade.findByDay(day);
	
		return clima;
	}
	
	
}
