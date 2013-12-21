package org.rcx.test.jsf2.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.rcx.test.jsf2.dto.CompteDTO;
import org.rcx.test.jsf2.metier.service.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Historique implements Serializable {

	private static final long serialVersionUID = 1L;

	private IMetier metier;
	
	private List<CompteDTO> comptes;  
	  
    private CompteDTO selectedCompte; 

	@PostConstruct
	private void beforeFirstRender() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-metier-dao.xml");
		metier = (IMetier) ctx.getBean("metierBDD");
		comptes = metier.getAllCompte();
		
//		if(comptes != null && !comptes.isEmpty() && selectedCompte == null){
//			selectedCompte = comptes.get(0);
//		}
	}

	public List<CompteDTO> getComptes() {
		return comptes;
	}

	public CompteDTO getSelectedCompte() {
		return selectedCompte;
	}

	public void setSelectedCompte(CompteDTO selectedCompte) {
		this.selectedCompte = selectedCompte;
	}

}
