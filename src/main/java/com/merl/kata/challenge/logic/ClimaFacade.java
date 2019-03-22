package com.merl.kata.challenge.logic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.merl.kata.challenge.domain.Clima;

@Stateless
public class ClimaFacade {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClimaFacade.class);

	@PersistenceContext(unitName = "storePU")
	private EntityManager em;

	public Clima create(int day, String period) {
		Clima p = new Clima(day, period);
		em.persist(p);
		return p;
	}

	public List<Clima> findByPeriod(String period) {
		LOGGER.debug("buscando por periodo:{}", period);
		String hint = '%' + period.toUpperCase().trim().replaceAll(" ", "%") + '%';
		TypedQuery<Clima> query = em
				.createQuery("select c from Clima c where UPPER( c.period ) like :period", Clima.class)
				.setParameter("period", hint);

		return query.getResultList();
	}

	public Clima findByDay(Integer day) {
		LOGGER.debug("buscando por day:{}", day);
		Clima clima = null;
		TypedQuery<Clima> query = em.createQuery("select p from Clima p  where p.day =:day", Clima.class)
				.setParameter("day", day);

		try {
			clima = query.getSingleResult();
		} catch (javax.persistence.NoResultException ex) {
			LOGGER.error("No existe periodo para el dia:{}", day);
		}
		return clima;
	}

	public void clearHistory() {
		Query query = em.createQuery("Delete from Clima ");
		query.executeUpdate();

	}

}
