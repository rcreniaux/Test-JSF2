package org.rcx.test.jsf2.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.primefaces.model.tagcloud.TagCloudItem;

import utils.MyTagCloudItem;

public class Search implements Serializable {

	private static final long serialVersionUID = 1L;

	private String searchValue;
	
	private TagCloudBean tagCloudBean;
	
	private Application applicationBean;
	
	public String getSearchValue() {
		return searchValue;
	}
	
	@PostConstruct
	private void toto() {
		System.out.println(applicationBean.getMetier());
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public void onSearch() {
		if("".equals(searchValue)){
			return;
		}
		
		int countTag = 0;
		TagCloudItem searchValueTagCloudItem = null;
		for (TagCloudItem tagCloudItem : tagCloudBean.getModel().getTags()) {
			if (tagCloudItem.getLabel().equals(searchValue)) {
				searchValueTagCloudItem = tagCloudItem;
				if(searchValueTagCloudItem.getStrength() == 5){
					return;
				}
				break;
			}
		}

		if (searchValueTagCloudItem != null) {
			countTag = searchValueTagCloudItem.getStrength();
			tagCloudBean.getModel().removeTag(searchValueTagCloudItem);
		}
		countTag++;
		tagCloudBean.getModel().addTag(new MyTagCloudItem(searchValue, countTag));

		System.out.println("Hello onSearch, searchValue " + searchValue + ", compteur:" + countTag);
	}

	public TagCloudBean getTagCloudBean() {
		return tagCloudBean;
	}

	public void setTagCloudBean(TagCloudBean tagCloudBean) {
		this.tagCloudBean = tagCloudBean;
	}

	public Application getApplicationBean() {
		return applicationBean;
	}

	public void setApplicationBean(Application application) {
		this.applicationBean = application;
	}


}
