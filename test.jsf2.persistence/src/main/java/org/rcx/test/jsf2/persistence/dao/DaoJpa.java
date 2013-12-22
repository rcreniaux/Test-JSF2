package org.rcx.test.jsf2.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.rcx.test.jsf2.persistence.entity.Compte;
import org.rcx.test.jsf2.persistence.entity.FavTrend;
import org.rcx.test.jsf2.persistence.entity.MouvementCompte;
import org.rcx.test.jsf2.persistence.exception.CompteException;
import org.rcx.test.jsf2.persistence.exception.FavTrendException;
import org.rcx.test.jsf2.persistence.exception.MouvementCompteException;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<MouvementCompte> getMouvementCompteByCompteId(Integer compteId) throws MouvementCompteException {
		try {
			return em.createNamedQuery("MouvementCompte.findByCompte").getResultList();
		} catch (Throwable th) {
			throw new MouvementCompteException(th);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getAllCompte() throws CompteException {
		try {
			return em.createNamedQuery("Compte.findAll").getResultList();
		} catch (Throwable th) {
			throw new CompteException(th);
		}
	}

	@Override
	public void saveMouvement(MouvementCompte mouvementCompte) {
		em.persist(mouvementCompte);

	}

	@Override
	public void updateMouvement(MouvementCompte mouvementCompte) {

		MouvementCompte mouvementCompteInDB = em.find(MouvementCompte.class, mouvementCompte.getId());

		em.getTransaction().begin();

		mouvementCompteInDB.setDate(mouvementCompte.getDate());
		mouvementCompteInDB.setMontant(mouvementCompte.getMontant());
		mouvementCompteInDB.setType(mouvementCompte.getType());
		mouvementCompteInDB.setCompte(mouvementCompte.getCompte());

		em.getTransaction().commit();

	}

	@Override
	public void deleteMouvement(MouvementCompte mouvementCompte) {

		em.find(MouvementCompte.class, mouvementCompte.getId());
		em.getTransaction().begin();
		em.remove(mouvementCompte);
		em.getTransaction().commit();
	}

	@Override
	public Compte getCompteById(Integer idCompte) throws CompteException {

		Compte compte = em.find(Compte.class, idCompte);

		if (compte == null) {
			throw new CompteException("compte introuvable pour id " + idCompte);
		}

		return em.find(Compte.class, idCompte);
	}

	@Override
	public List<MouvementCompte> getAllMouvementCompte() throws MouvementCompteException {
		try {
			return em.createNamedQuery("MouvementCompte.findAll").getResultList();
		} catch (Throwable th) {
			throw new MouvementCompteException(th);
		}
	}

}
