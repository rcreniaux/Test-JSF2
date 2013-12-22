package org.rcx.test.jsf2.dto;

import java.io.Serializable;
import java.util.Date;

public class MouvementDTO implements Serializable{
	
	private static final long serialVersionUID = 972807460092707954L;

	private Integer id;
	
	private Float montant;
	
	private Date date;
	
	private String type;
	
	private CompteDTO compte;
	
	public MouvementDTO(Integer id, Float montant, Date date, String type, CompteDTO compte) {
		super();
		this.id = id;
		this.montant = montant;
		this.date = date;
		this.type = type;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CompteDTO getCompte() {
		return compte;
	}

	public void setCompte(CompteDTO compte) {
		this.compte = compte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compte == null) ? 0 : compte.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((montant == null) ? 0 : montant.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MouvementDTO other = (MouvementDTO) obj;
		if (compte == null) {
			if (other.compte != null)
				return false;
		} else if (!compte.equals(other.compte))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (montant == null) {
			if (other.montant != null)
				return false;
		} else if (!montant.equals(other.montant))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
}
