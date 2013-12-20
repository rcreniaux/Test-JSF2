package org.rcx.test.jsf2.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trends_fav database table.
 * 
 */
@Entity
@Table(name="FAV_TREND")
@NamedQuery(name="FavTrend.findAll", query="SELECT t FROM FavTrend t")
public class FavTrend implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String value;

	public FavTrend() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}