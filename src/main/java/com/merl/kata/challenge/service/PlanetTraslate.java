package com.merl.kata.challenge.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.merl.kata.challenge.model.Planet;
import com.merl.kata.challenge.model.TurnType;
import com.merl.kata.challenge.util.Constants;

public class PlanetTraslate {

	public void traslate(Planet planet) {
		int desplazamientoAngular = planet.getDesplazamientoAngular().intValue();
		if (planet.getTurn().equals(TurnType.ANTI_CLOCK) && desplazamientoAngular > 0) {
			if (planet.getDesplazamientoAngular() < 360)
				planet.setDesplazamientoAngular(360 - planet.getDesplazamientoAngular());
		}
	}

	public void nextDay(Planet planet) {
		calculatePositionXY(planet);
		//calculatePositionY(planet);
		planet.setDesplazamientoFinal(planet.getDesplazamientoFinal() + (planet.getVelocity() * Constants.INTERVAL_DAY));
		if (planet.getDesplazamientoFinal() > 360) {
			planet.setDesplazamientoAngular(planet.getDesplazamientoFinal() % 360);
		} else {
			planet.setDesplazamientoAngular(planet.getDesplazamientoFinal());
		}
		// System.out.println("UBICACION"+devolverAnguloEnCuadrante(planet.getDesplazamientoAngular()).doubleValue());

	}

	public void calculatePositionXY(Planet planet) {
		
		planet.setAnguloCuadrante(devolverAnguloEnCuadrante(planet.getDesplazamientoAngular()));
		//calculatePositionX(planet);
		//calculatePositionY(planet);
		if(this.esPrimerCuadrante(planet.getDesplazamientoAngular())) {
			planet.setPositionX(calculatePositionCos(planet));
			planet.setPositionY(calculatePositionSin(planet));
		}
		if(this.esSegundoCuadrante(planet.getDesplazamientoAngular())) {
			planet.setPositionX(calculatePositionSin(planet));
			planet.setPositionY(calculatePositionCos(planet)*-1);
		}
		if(this.esTercerCuadrante(planet.getDesplazamientoAngular())) {
			planet.setPositionX(calculatePositionCos(planet)*-1);
			planet.setPositionY(calculatePositionSin(planet)*-1);
		}
		if(this.esCuartoCuadrante(planet.getDesplazamientoAngular())) {
			planet.setPositionX(calculatePositionSin(planet)*-1);
			planet.setPositionY(calculatePositionCos(planet));
		}

	}

	private double  calculatePositionCos(Planet planet) {
		
		double anguloRadianes = Math.toRadians(planet.getAnguloCuadrante());
		double position = planet.getRadius() * Math.cos(anguloRadianes);
		BigDecimal bd = new BigDecimal(position);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
		//planet.setPositionX(position);
	}

	private double calculatePositionSin(Planet planet) {
		double anguloRadianes = Math.toRadians(planet.getAnguloCuadrante());
		double position = planet.getRadius() * Math.sin(anguloRadianes);
		BigDecimal bd = new BigDecimal(position);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
		//planet.setPositionY(position);
	}

	private Integer devolverAnguloEnCuadrante(Integer desplazamiento) {

		if (desplazamiento < 90) {
			return 90 - desplazamiento;
		}
		if (desplazamiento < 180)
			return 180 - desplazamiento;

		if (desplazamiento < 270)
			return 270 - desplazamiento;

		if (desplazamiento < 360)
			return 360 - desplazamiento;

		return desplazamiento;
	}

	private boolean esPrimerCuadrante(Integer desplazamiento) {
		return desplazamiento>0 && desplazamiento < 90;
	}

	private boolean esSegundoCuadrante(Integer desplazamiento) {
		return desplazamiento>90 && desplazamiento < 180;
	}
	private boolean esTercerCuadrante(Integer desplazamiento) {
		return desplazamiento>180 && desplazamiento < 270;
	}
	private boolean esCuartoCuadrante(Integer desplazamiento) {
		return desplazamiento>270 && desplazamiento < 360;
	}
}
