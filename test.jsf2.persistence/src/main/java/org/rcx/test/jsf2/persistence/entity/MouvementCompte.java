package org.rcx.test.jsf2.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the mouvement_compte database table.
 * 
 */
@Entity
@Table(name = "mouvement_compte")
@NamedQueries(value = { @NamedQuery(name = "MouvementCompte.findAll", query = "SELECT m FROM MouvementCompte m"),
		@NamedQuery(name = "MouvementCompte.findByCompte", query = "SELECT m FROM MouvementCompte m WHERE m.compte.id = :compteId") })
public class MouvementCompte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private float montant;

	private String type;

	// bi-directional many-to-one association to Compte
	@ManyToOne
	private Compte compte;

	public MouvementCompte() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getMontant() {
		return this.montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}