package org.rcx.test.jsf2.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.rcx.test.jsf2.dto.CompteDTO;

@FacesConverter("org.rcx.test.jsf2.web.converter.CompteConverter")
public class CompteConverter implements Converter {

	private static final String SEPARATOR = ";";

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.trim().equals("")) {  
            return null;  
        } 
		
		String[] compteDTOAsString = value.split(";");
		Integer id = null;
		try{
			id = Integer.parseInt(compteDTOAsString[0]);
		}
		catch(NumberFormatException e){
			e.printStackTrace();
			return null;
		}
		return new CompteDTO(id, compteDTOAsString[1], compteDTOAsString[2]);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value instanceof CompteDTO){
			CompteDTO compteDTO = (CompteDTO) value;
			
			StringBuilder sb = new StringBuilder();
			sb.append(compteDTO.getId());
			sb.append(SEPARATOR);
			sb.append(compteDTO.getLabel());
			sb.append(SEPARATOR);
			sb.append(compteDTO.getPays());
			
			return sb.toString();
		}
		
		if(value instanceof String){
			return (String) value;
		}
		
		return null;

	}

}
