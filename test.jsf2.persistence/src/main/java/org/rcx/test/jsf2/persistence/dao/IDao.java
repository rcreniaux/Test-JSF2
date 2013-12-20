package org.rcx.test.jsf2.persistence.dao;


import java.util.List;

import org.rcx.test.jsf2.persistence.entity.FavTrend;
import org.rcx.test.jsf2.persistence.exception.FavTrendException;

public interface IDao {
	
	public List<FavTrend> getAllFavTrend() throws FavTrendException;

}
