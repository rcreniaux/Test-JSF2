package org.rcx.test.jsf2.metier.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.rcx.test.jsf2.dto.CompteDTO;
import org.rcx.test.jsf2.dto.MouvementDTO;
import org.rcx.test.jsf2.persistence.dao.IDao;
import org.rcx.test.jsf2.persistence.entity.Compte;
import org.rcx.test.jsf2.persistence.exception.CompteException;

public class MetierBDD implements IMetier, Serializable {

	private static final long serialVersionUID = -5911820046299590353L;
	
	private IDao dao;

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	public List<CompteDTO> getAllCompte() {

		List<CompteDTO> result = new ArrayList<CompteDTO>();
		try {
			List<Compte> comptes = dao.getAllCompte();
			for (Compte compte : comptes) {
				result.add(new CompteDTO(compte.getId(), compte.getLabel(), compte.getPays()));
			}
		} catch (CompteException e) {
			Logger.getLogger(MetierBDD.class.getName()).log(Level.SEVERE, null, e);
		}

		return result;
	}

	@Override
	public void saveMouvement(MouvementDTO mouvementDTO) {
		// TODO Auto-generated method stub
		
	}

}
