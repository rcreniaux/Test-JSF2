package org.rcx.test.rest2.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.rcx.test.jsf2.persistence.dao.IDao;
import org.rcx.test.jsf2.persistence.entity.Compte;
import org.rcx.test.jsf2.persistence.exception.CompteException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/comptes")
public class RESTServiceCompte {

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
	public String getIt() {
		
		initDao();

		try {
			StringBuilder sb = new StringBuilder();
			List<Compte> comptes = dao.getAllCompte();
			for (Compte compte : comptes) {
				sb.append(compte.getId());
				sb.append(SEPARATOR);
				sb.append(compte.getLabel());
				sb.append(SEPARATOR);
				sb.append(compte.getPays());
				sb.append("\n");
			}
			return sb.toString();
		} catch (CompteException e) {
			e.printStackTrace();
		}
		return null;
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
