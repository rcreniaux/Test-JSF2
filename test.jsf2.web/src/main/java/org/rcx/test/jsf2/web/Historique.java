package org.rcx.test.jsf2.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.rcx.test.jsf2.dto.MouvementDTO;
import org.rcx.test.jsf2.metier.service.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Historique implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<MouvementDTO> mouvements;

	private IMetier metier;
	
	private String text;

	@PostConstruct
	private void beforeFirstRender() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-metier-dao.xml");
		metier = (IMetier) ctx.getBean("metierREST");
		refreshData();
	}

	public void refreshData() {
		mouvements = metier.getAllMouvement();
	}

	public List<MouvementDTO> getMouvements() {
		return mouvements;
	}

	public void setMouvements(List<MouvementDTO> mouvements) {
		this.mouvements = mouvements;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void increment() {
		this.text = text + "a";
	}

}
