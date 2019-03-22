package com.merl.kata.challenge.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clima")
public class Clima implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "day")
	private Integer day;

	@Column(name = "period", length = 50)
	private String period;

	@Column(name = "perimetro")
	private Integer perimetro;

	
	public Clima() {

	}

	public Clima(int day, String period) {
		this.day = day;
		this.period = period;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 71 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Clima other = (Clima) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "Clima{" + "Id=" + id + ", day=" + day+ ", period=" + period+ '}';
	}

	public Integer getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(Integer perimetro) {
		this.perimetro = perimetro;
	}


}
