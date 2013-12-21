package org.rcx.test.jsf2.metier.service;

import java.util.List;

import org.rcx.test.jsf2.persistence.entity.FavTrend;

public interface IMetier {

	public List<FavTrend> getAllFavTrend();

	public void getTwittsBySearch(String searchValue);
}
