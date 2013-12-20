package org.rcx.test.jsf2.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;

import utils.MyTagCloudItem;

public class TagCloudBean implements Serializable {
	
	private static final long serialVersionUID = 3830899898279213160L;
	
	private TagCloudModel model;  
    
    public TagCloudBean() {  
        model = new DefaultTagCloudModel();  
        model.addTag(new MyTagCloudItem("Transformers", 1));  
        model.addTag(new MyTagCloudItem("RIA", 3));  
        model.addTag(new MyTagCloudItem("AJAX", 2));  
        model.addTag(new MyTagCloudItem("jQuery", 15));  
        model.addTag(new MyTagCloudItem("NextGen", 4));  
        model.addTag(new MyTagCloudItem("JSF 2.0", 2));  
        model.addTag(new MyTagCloudItem("FCB", 5));  
        model.addTag(new MyTagCloudItem("Mobile",  3));  
        model.addTag(new MyTagCloudItem("Themes", 4));  
        model.addTag(new MyTagCloudItem("Rocks", 1));  
    }  
  
    public TagCloudModel getModel() {  
        return model;  
    }  
      
    public void onSelect(SelectEvent event) {  
        TagCloudItem item = (TagCloudItem) event.getObject();  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", item.getLabel());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  

}
