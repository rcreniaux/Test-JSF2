package org.rcx.test.jsf2.dto;

import java.io.Serializable;

public class CompteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String label;
	
	private String pays;
	
	public CompteDTO(Integer id, String label, String pays) {
		super();
		this.id = id;
		this.label = label;
		this.pays = pays;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	

}
