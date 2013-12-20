package org.rcx.test.jsf2.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.rcx.test.jsf2.persistence.entity.FavTrend;
import org.rcx.test.jsf2.persistence.exception.FavTrendException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DaoJpa implements IDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<FavTrend> getAllFavTrend() throws FavTrendException {
		try {
			return em.createNamedQuery("FavTrend.findAll").getResultList();
		} catch (Throwable th) {
			throw new FavTrendException(th);
		}
	}

}
