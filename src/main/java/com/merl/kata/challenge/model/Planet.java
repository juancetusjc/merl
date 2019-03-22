package com.merl.kata.challenge.model;

public class Planet {

	private String name;
	private Integer desplazamientoInicial = 0;
	private Integer desplazamientoFinal = 0;
	private Integer desplazamientoAngular = 0;
	private Integer anguloCuadrante = 0;
	private Integer dias;
	private Integer radius;
	private TurnType turn;
	private Integer velocity;
	private boolean referring = false;
	private double positionX = 0;
	private double positionY = 0;

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	public TurnType getTurn() {
		return turn;
	}

	public void setTurn(TurnType turn) {
		this.turn = turn;
	}

	public void asingPositionInitialToCreation(Integer position) {
		desplazamientoInicial = position;
		desplazamientoFinal = position;

	}

	public Integer obtainDaysForYear() {
		Integer daysForYear = 360 / velocity;
		return daysForYear;
	}

	public Integer getDesplazamientoFinal() {
		return desplazamientoFinal;
	}

	public void setDesplazamientoFinal(Integer desplazamientoFinal) {
		this.desplazamientoFinal = desplazamientoFinal;
	}

	public Integer getVelocity() {
		return velocity;
	}

	public void setVelocity(Integer velocity) {
		this.velocity = velocity;
	}

	public Integer getDesplazamientoAngular() {
		return desplazamientoAngular;
	}

	public void setDesplazamientoAngular(Integer desplazamientoAngular) {
		this.desplazamientoAngular = desplazamientoAngular;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isReferring() {
		return referring;
	}

	public void setReferring(boolean referring) {
		this.referring = referring;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public Integer getAnguloCuadrante() {
		return anguloCuadrante;
	}

	public void setAnguloCuadrante(Integer anguloCuadrante) {
		this.anguloCuadrante = anguloCuadrante;
	}

}
