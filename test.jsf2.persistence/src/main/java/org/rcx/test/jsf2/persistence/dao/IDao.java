package org.rcx.test.jsf2.persistence.dao;


import java.util.List;

import org.rcx.test.jsf2.persistence.entity.Compte;
import org.rcx.test.jsf2.persistence.entity.FavTrend;
import org.rcx.test.jsf2.persistence.entity.MouvementCompte;
import org.rcx.test.jsf2.persistence.exception.CompteException;
import org.rcx.test.jsf2.persistence.exception.FavTrendException;
import org.rcx.test.jsf2.persistence.exception.MouvementCompteException;

public interface IDao {
	
	public List<FavTrend> getAllFavTrend() throws FavTrendException;
	
	public List<MouvementCompte> getMouvementCompteByCompteId(Integer compteId) throws MouvementCompteException;
	
	public List<Compte> getAllCompte() throws CompteException;

}
