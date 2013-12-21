package org.rcx.test.rest2.ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.rcx.test.jsf2.persistence.dao.IDao;
import org.rcx.test.jsf2.persistence.entity.Compte;
import org.rcx.test.jsf2.persistence.entity.MouvementCompte;
import org.rcx.test.jsf2.persistence.exception.CompteException;
import org.rcx.test.jsf2.persistence.exception.MouvementCompteException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/mouvement")
public class RESTServiceMouvement {

	private static final String SEPARATOR = ";";
	private IDao dao;

	/**
	 * Method processing HTTP GET requests, producing "text/plain" MIME media
	 * type.
	 * 
	 * @return String that will be send back as a response of type "text/plain".
	 */
	@GET
	@Produces("text/plain")
	@Path("/{param}")
	public Response getIt(@PathParam("param") Integer compteId) {

		initDao();

		try {
			StringBuilder sb = new StringBuilder();
			List<MouvementCompte> mComptes = dao.getMouvementCompteByCompteId(compteId);
			for (MouvementCompte mCompte : mComptes) {
				sb.append(mCompte.getId());
				sb.append(SEPARATOR);
				sb.append(mCompte.getMontant());
				sb.append(SEPARATOR);
				sb.append(mCompte.getType());
				sb.append(SEPARATOR);
				sb.append(mCompte.getDate());
				sb.append("\n");
			}
			return Response.status(200).entity(sb.toString()).build();
		} catch (MouvementCompteException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}

	@PUT
	@Produces("text/plain")
	@Path("/{montant}/{type}/{date}/{compteId}")
	public Response putIt(@PathParam("montant") Float montant, @PathParam("type") String type, @PathParam("date") String date, @PathParam("compteId") Integer compteId) {

		initDao();

		Compte compte;
		try {
			compte = dao.getCompteById(compteId);
		} catch (CompteException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dateParsed;
		try {
			dateParsed = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}

		MouvementCompte mouvementCompte = new MouvementCompte(dateParsed, montant, type, compte);
		dao.saveMouvement(mouvementCompte);
		
		return Response.status(200).build();
	}

	private void initDao() {
		if (dao == null) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-metier-dao.xml");
			dao = (IDao) ctx.getBean("dao");
		}
	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}
}
