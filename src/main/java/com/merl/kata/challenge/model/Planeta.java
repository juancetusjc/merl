package com.merl.kata.challenge.model;

public class Planeta {

	private Integer desplazamientoInicial;
	private Integer dias;
	private Integer distanciaAlSol;
	private GiroType sentidoGiro;

	public Integer getDesplazamientoInicial() {
		return desplazamientoInicial;
	}

	public void setDesplazamientoInicial(Integer desplazamientoInicial) {
		this.desplazamientoInicial = desplazamientoInicial;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Integer getDistanciaAlSol() {
		return distanciaAlSol;
	}

	public void setDistanciaAlSol(Integer distanciaAlSol) {
		this.distanciaAlSol = distanciaAlSol;
	}

	public GiroType getSentidoGiro() {
		return sentidoGiro;
	}

	public void setSentidoGiro(GiroType sentidoGiro) {
		this.sentidoGiro = sentidoGiro;
	}

	public void calcularDesplazamiento() {

	}

}
