package utils;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trends_fav database table.
 * 
 */
@Entity
@Table(name="trends_fav")
@NamedQuery(name="TrendsFav.findAll", query="SELECT t FROM TrendsFav t")
public class TrendsFav implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String value;

	public TrendsFav() {
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