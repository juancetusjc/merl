package com.merl.kata.challenge.rest;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.merl.kata.challenge.logic.ClimaFacade;

@Path("clear")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class ClearHistoryREST {


	@Inject
	private ClimaFacade facade; 

	
	@GET
	public String clear() {
		//Clima clima=facade.findByDay(day);
		facade.clearHistory();
		return "OK";
	}
	
	
}
