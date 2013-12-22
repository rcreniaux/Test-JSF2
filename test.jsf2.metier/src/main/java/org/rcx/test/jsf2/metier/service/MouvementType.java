package org.rcx.test.jsf2.metier.service;

public enum MouvementType {

	DEBIT(1, "Débit"), CREDIT(2, "Crédit");

	private int id;
	private String label;

	MouvementType(int id, String label) {
		this.setId(id);
		this.setLabel(label);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static MouvementType getMouvementTypeFromLabel(String label) {
		if (DEBIT.getLabel().equals(label)) {
			return DEBIT;
		}
		return CREDIT;
	}

	public static MouvementType getMouvementTypeFromId(int id) {
		if (DEBIT.getId() == id) {
			return DEBIT;
		}
		return CREDIT;
	}

}
