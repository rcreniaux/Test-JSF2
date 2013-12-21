package org.rcx.test.jsf2.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the compte database table.
 * 
 */
@Entity
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="`LABEL`")
	private String label;

	private String pays;

	//bi-directional many-to-one association to MouvementCompte
	@OneToMany(mappedBy="compte")
	private List<MouvementCompte> mouvementComptes;

	public Compte() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public List<MouvementCompte> getMouvementComptes() {
		return this.mouvementComptes;
	}

	public void setMouvementComptes(List<MouvementCompte> mouvementComptes) {
		this.mouvementComptes = mouvementComptes;
	}

	public MouvementCompte addMouvementCompte(MouvementCompte mouvementCompte) {
		getMouvementComptes().add(mouvementCompte);
		mouvementCompte.setCompte(this);

		return mouvementCompte;
	}

	public MouvementCompte removeMouvementCompte(MouvementCompte mouvementCompte) {
		getMouvementComptes().remove(mouvementCompte);
		mouvementCompte.setCompte(null);

		return mouvementCompte;
	}

}