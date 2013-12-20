package org.rcx.test.jsf2.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.rcx.test.jsf2.metier.service.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application implements Serializable {

	private static final long serialVersionUID = -6083779339902607841L;

	private IMetier metier;

	private List<Erreur> erreurs = new ArrayList<Erreur>();
	private Boolean erreur = false;

	public Application() {
		try {
			// instanciation couche [métier]
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-metier-dao.xml");
			metier = (IMetier) ctx.getBean("metier");
		} catch (Throwable th) {
			// on note l'erreur
			erreur = true;
			erreurs.add(new Erreur(th.getClass().getName(), th.getMessage()));
			while (th.getCause() != null) {
				th = th.getCause();
				erreurs.add(new Erreur(th.getClass().getName(), th.getMessage()));
			}
			return;
		}
	}

	// getters
	public Boolean getErreur() {
		return erreur;
	}

	public List<Erreur> getErreurs() {
		return erreurs;
	}

	public IMetier getMetier() {
		return metier;
	}

	public void setMetier(IMetier metier) {
		this.metier = metier;
	}
}
