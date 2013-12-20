package org.rcx.test.jsf2.metier.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.rcx.test.jsf2.persistence.dao.IDao;
import org.rcx.test.jsf2.persistence.entity.FavTrend;
import org.rcx.test.jsf2.persistence.exception.FavTrendException;

public class Metier implements IMetier {

	private IDao dao;

	public List<FavTrend> getAllFavTrend() {
		try {
			return dao.getAllFavTrend();
		} catch (FavTrendException e) {
			Logger.getLogger(Metier.class.getName()).log(Level.SEVERE, null, e);
			return new ArrayList<FavTrend>();
		}
	}

}
