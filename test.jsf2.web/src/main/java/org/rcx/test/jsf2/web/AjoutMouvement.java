package org.rcx.test.jsf2.web;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
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
	
	private String compteSave;
	private String montantSave;
	private String typeSave;
	private String dateSave;
	
	
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
		
		compteSave = selectedCompte.getLabel();
		montantSave = montant.toString();
		typeSave = typeOperation;
		dateSave = new SimpleDateFormat("dd-MM-yyyy").format(date);
		
		raz();
		RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
	}
	
	public void raz(){
		typeOperation = "Débit";
		selectedCompte = null;
		montant = null;
		date = new Date();
	}

	public String getDateSave() {
		return dateSave;
	}

	public void setDateSave(String dateSave) {
		this.dateSave = dateSave;
	}

	public String getTypeSave() {
		return typeSave;
	}

	public void setTypeSave(String typeSave) {
		this.typeSave = typeSave;
	}

	public String getMontantSave() {
		return montantSave;
	}

	public void setMontantSave(String montantSave) {
		this.montantSave = montantSave;
	}

	public String getCompteSave() {
		return compteSave;
	}

	public void setCompteSave(String compteSave) {
		this.compteSave = compteSave;
	}

}
