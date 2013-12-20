package org.rcx.test.jsf2.web;

import java.io.Serializable;

public class Erreur implements Serializable {

	private static final long serialVersionUID = 5545100116759230058L;

	public Erreur() {
	}

	private String classe;
	private String message;

	public Erreur(String classe, String message) {
		this.setClasse(classe);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

}
