package org.rcx.test.jsf2.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.rcx.test.jsf2.dto.CompteDTO;
import org.rcx.test.jsf2.dto.MouvementDTO;
import org.rcx.test.jsf2.metier.service.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AjoutMouvement implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private IMetier metier;
	
	private Date date = new Date();
	
	private String typeOperation = "Débit";
	
	private Float montant;
	
	private CompteDTO selectedCompte;
	
	private CompteDTO compte;
	
	private List<CompteDTO> comptes;
	
	@PostConstruct
	private void beforeFirstRender() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-metier-dao.xml");
		metier = (IMetier) ctx.getBean("metierREST");
		comptes = metier.getAllCompte();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public CompteDTO getSelectedCompte() {
		return selectedCompte;
	}

	public void setSelectedCompte(CompteDTO selectedCompte) {
		this.selectedCompte = selectedCompte;
	}

	public List<CompteDTO> getComptes() {
		return comptes;
	}

	public void setComptes(List<CompteDTO> comptes) {
		this.comptes = comptes;
	}

	public CompteDTO getCompte() {
		return compte;
	}

	public void setCompte(CompteDTO compte) {
		this.compte = compte;
	}
	
	public void saveMouvement(){
		MouvementDTO mouvementDTO = new MouvementDTO(null, montant, date, typeOperation, selectedCompte);
		mouvementDTO.setCompte(selectedCompte);
		metier.saveMouvement(mouvementDTO);
		raz();
	}
	
	public void raz(){
		typeOperation = "Débit";
		selectedCompte = null;
		montant = null;
		date = new Date();
	}

}
