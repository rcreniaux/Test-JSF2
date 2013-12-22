package org.rcx.test.jsf2.persistence.dao;


import java.util.List;

import org.rcx.test.jsf2.persistence.entity.Compte;
import org.rcx.test.jsf2.persistence.entity.FavTrend;
import org.rcx.test.jsf2.persistence.entity.MouvementCompte;
import org.rcx.test.jsf2.persistence.exception.CompteException;
import org.rcx.test.jsf2.persistence.exception.FavTrendException;
import org.rcx.test.jsf2.persistence.exception.MouvementCompteException;

public interface IDao {
	
	List<FavTrend> getAllFavTrend() throws FavTrendException;
	
	List<MouvementCompte> getMouvementCompteByCompteId(Integer compteId) throws MouvementCompteException;
	
	List<MouvementCompte> getAllMouvementCompte() throws MouvementCompteException;
	
	List<Compte> getAllCompte() throws CompteException;
	
	Compte getCompteById(Integer idCompte) throws CompteException;
	
	void saveMouvement(MouvementCompte mouvementCompte);
	
	void deleteMouvement(MouvementCompte mouvementCompte);

	void updateMouvement(MouvementCompte mouvementCompte);
	
}
