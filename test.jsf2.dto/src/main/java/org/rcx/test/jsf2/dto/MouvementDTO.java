package org.rcx.test.jsf2.dto;

import java.util.Date;

public class MouvementDTO {
	
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
	
	
	
}
