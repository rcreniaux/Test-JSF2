package org.rcx.test.jsf2.web;

import java.util.List;

import org.rcx.test.jsf2.dto.CompteDTO;
import org.rcx.test.jsf2.dto.MouvementDTO;
import org.rcx.test.jsf2.metier.service.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	private List<CompteDTO> comptes;
	private List<MouvementDTO> mouvements;
	
	private Historique historiqueBean;
	
	private IMetier metier;
	
	public void initData() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-metier-dao.xml");
		metier = (IMetier) ctx.getBean("metierREST");
		refreshData();
		historiqueBean.setMouvements(mouvements);
	}
	
	public void refreshData() {
		comptes = metier.getAllCompte();
		mouvements = metier.getAllMouvement();
	}

	public List<CompteDTO> getComptes() {
		return comptes;
	}

	public void setComptes(List<CompteDTO> comptes) {
		this.comptes = comptes;
	}

	public List<MouvementDTO> getMouvements() {
		return mouvements;
	}

	public void setMouvements(List<MouvementDTO> mouvements) {
		this.mouvements = mouvements;
	}

	public Historique getHistoriqueBean() {
		return historiqueBean;
	}

	public void setHistoriqueBean(Historique historiqueBean) {
		this.historiqueBean = historiqueBean;
	}

}
