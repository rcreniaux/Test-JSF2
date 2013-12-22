package org.rcx.test.jsf2.metier.service;

import java.util.List;

import org.rcx.test.jsf2.dto.CompteDTO;
import org.rcx.test.jsf2.dto.MouvementDTO;

public interface IMetier {

	public List<CompteDTO> getAllCompte();

	public void saveMouvement(MouvementDTO mouvementDTO);

	public List<MouvementDTO> getAllMouvement();
}
