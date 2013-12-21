package org.rcx.test.jsf2.metier.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.rcx.test.jsf2.persistence.dao.IDao;
import org.rcx.test.jsf2.persistence.entity.FavTrend;
import org.rcx.test.jsf2.persistence.exception.FavTrendException;

public class Metier implements IMetier {

	private IDao dao;

	public List<FavTrend> getAllFavTrend() {
		try {
			return dao.getAllFavTrend();
		} catch (FavTrendException e) {
			Logger.getLogger(Metier.class.getName()).log(Level.SEVERE, null, e);
			return new ArrayList<FavTrend>();
		}
	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	public void getTwittsBySearch(String searchValue) {
		
		try {
			 
			URL url = new URL("https://api.twitter.com/1.1/search/tweets.json?q=%23freebandnames&since_id=24012619984051000&max_id=250126199840518145&result_type=mixed&count=4");
			

			
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "OAuth oauth_consumer_key=\"wyr47I3RhntymE0EGlqokA\", oauth_nonce=\"167c94081094d933e6f7f0142ad647cd\", oauth_signature=\"%2Ff15yKAPpGl7Gujw29Td9b%2FjeJ4%3D\", oauth_signature_method=\"HMAC-SHA1\", oauth_timestamp=\"1387583250\", oauth_token=\"1068321301-X3vISRkMTM0a6nH7txsUrnYneK6sjooOx978Jgl\", oauth_version=\"1.0\"");
	 
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
	 
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			conn.disconnect();
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		
	}

}
