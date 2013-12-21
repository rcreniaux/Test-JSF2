package org.rcx.test.jsf2.metier.service;

import java.util.List;

import org.rcx.test.jsf2.dto.CompteDTO;
import org.rcx.test.jsf2.persistence.entity.FavTrend;

public interface IMetier {

	public List<FavTrend> getAllFavTrend();
	
	public List<CompteDTO> getAllCompte();

	public void getTwittsBySearch(String searchValue);
}
