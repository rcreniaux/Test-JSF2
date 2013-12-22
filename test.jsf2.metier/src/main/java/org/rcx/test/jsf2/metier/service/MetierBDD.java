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
import org.rcx.test.jsf2.persistence.entity.MouvementCompte;
import org.rcx.test.jsf2.persistence.exception.CompteException;
import org.rcx.test.jsf2.persistence.exception.MouvementCompteException;

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
				result.add(getCompteDTOFromEntity(compte));
			}
		} catch (CompteException e) {
			Logger.getLogger(MetierBDD.class.getName()).log(Level.SEVERE, null, e);
		}

		return result;
	}

	private CompteDTO getCompteDTOFromEntity(Compte compte) {
		return new CompteDTO(compte.getId(), compte.getLabel(), compte.getPays());
	}

	@Override
	public void saveMouvement(MouvementDTO mouvementDTO) {
		MouvementCompte mouvementCompte = getMouvementCompteFromDTO(mouvementDTO);
		if(mouvementCompte != null){
			dao.saveMouvement(mouvementCompte);
		}
	}

	private MouvementCompte getMouvementCompteFromDTO(MouvementDTO mouvementDTO) {
		Compte compte = getCompteFromDTO(mouvementDTO);
		if(compte == null){
			return null;
		}
		
		MouvementType type = MouvementType.getMouvementTypeFromLabel(mouvementDTO.getType());
		return new MouvementCompte(mouvementDTO.getDate(), mouvementDTO.getMontant(), type.getId(), compte);
	}

	private Compte getCompteFromDTO(MouvementDTO mouvementDTO) {
		Compte compte;
		try {
			compte = dao.getCompteById(mouvementDTO.getCompte().getId());
		} catch (CompteException e) {
			Logger.getLogger(MetierBDD.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return compte;
	}

	@Override
	public List<MouvementDTO> getAllMouvement() {
		List<MouvementDTO> result = new ArrayList<MouvementDTO>();
		try {
			List<MouvementCompte> mouvements = dao.getAllMouvementCompte();
			for (MouvementCompte mouvement : mouvements) {
				result.add(getMouvementDTOFromEntity(mouvement));
			}
		} catch (MouvementCompteException e) {
			Logger.getLogger(MetierBDD.class.getName()).log(Level.SEVERE, null, e);
		}

		return result;
	}

	private MouvementDTO getMouvementDTOFromEntity(MouvementCompte mouvement) {
		MouvementType type = MouvementType.getMouvementTypeFromId(mouvement.getType());
		return new MouvementDTO(mouvement.getId(), mouvement.getMontant(), mouvement.getDate(), type.getLabel(), getCompteDTOFromEntity(mouvement.getCompte()));
	}

}
