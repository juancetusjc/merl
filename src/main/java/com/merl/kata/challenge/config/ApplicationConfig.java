package com.merl.kata.challenge.config;

import java.util.Set;

import javax.ws.rs.core.Application;

import com.merl.kata.challenge.rest.ClearHistoryREST;
import com.merl.kata.challenge.rest.ClimaREST;
import com.merl.kata.challenge.rest.PredictionREST;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application  {
	  @Override
	    public Set<Class<?>> getClasses() {
	        Set<Class<?>> resources = new java.util.HashSet<>();
	        addRestResourceClasses(resources);
	        return resources;
	    }

	    private void addRestResourceClasses(Set<Class<?>> resources) {
	        resources.add(ClimaREST.class);
	        resources.add(PredictionREST.class);
	        resources.add(ClearHistoryREST.class);
	    }

}
