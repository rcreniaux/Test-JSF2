package org.rcx.test.jsf2.metier.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.rcx.test.jsf2.dto.CompteDTO;
import org.rcx.test.jsf2.dto.MouvementDTO;

public class MetierREST implements IMetier, Serializable {

	private static final long serialVersionUID = -5911820046299590353L;

	public List<CompteDTO> getAllCompte() {

		List<CompteDTO> compteDTOs = new ArrayList<CompteDTO>();
		try {

			URL url = new URL("http://localhost:8080/test.rest2.ws/webresources/comptes");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "text/plain");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				String[] compteDTOAsString = output.split(";");
				CompteDTO compteDTO = new CompteDTO(Integer.parseInt(compteDTOAsString[0]), compteDTOAsString[1], compteDTOAsString[2]);
				compteDTOs.add(compteDTO);
			}

			conn.disconnect();

			return compteDTOs;

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return null;

	}

	@Override
	public void saveMouvement(MouvementDTO mouvementDTO) {

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
			String dateStr = sdf.format(mouvementDTO.getDate());
			
			MouvementType type = MouvementType.getMouvementTypeFromLabel(mouvementDTO.getType());

			String urlStr = "http://localhost:8080/test.rest2.ws/webresources/mouvement/" + mouvementDTO.getMontant() + "/" +type.getId() + "/" + dateStr + "/"
					+ mouvementDTO.getCompte().getId();

			URL url = new URL(urlStr);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

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

	@Override
	public List<MouvementDTO> getAllMouvement() {

		List<MouvementDTO> result = new ArrayList<MouvementDTO>();
		try {

			String urlStr = "http://localhost:8080/test.rest2.ws/webresources/mouvement/";

			URL url = new URL(urlStr);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			String output;
			while ((output = br.readLine()) != null) {
				String[] compteDTOAsString = output.split(";");
				
				MouvementType mouvementType = MouvementType.getMouvementTypeFromId(Integer.parseInt(compteDTOAsString[6]));
				
				CompteDTO compteDTO = new CompteDTO(Integer.parseInt(compteDTOAsString[0]), compteDTOAsString[1], compteDTOAsString[2]);
				MouvementDTO mouvementDTO = new MouvementDTO(Integer.parseInt(compteDTOAsString[3]), Float.parseFloat(compteDTOAsString[4]), sdf.parse(compteDTOAsString[5]),
						mouvementType.getLabel(), compteDTO);
				result.add(mouvementDTO);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return result;
	}

}
