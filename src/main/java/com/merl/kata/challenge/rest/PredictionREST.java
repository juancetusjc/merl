package com.merl.kata.challenge.rest;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.merl.kata.challenge.schedule.CalculatorPredictionSchedule;

@Path("prediction")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class PredictionREST {

	@Inject
	private CalculatorPredictionSchedule predictionService; 
	
	@GET
	public String findByDay(@QueryParam("year") Integer year) {
		//Clima clima=facade.findByDay(day);
		predictionService.initSchedule();
		predictionService.calculatePrediction(year);
		return "OK";
	}
	
	
}
