package org.rcx.test.jsf2.web;

import java.io.Serializable;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.rcx.test.jsf2.web.pfbean.TagCloudBean;

import utils.MyTagCloudItem;

public class Search implements Serializable {

	private static final long serialVersionUID = 1L;

	private String searchText;
	
	private String searchValueDisplay;

	private TagCloudBean tagCloudBean;

	public String getSearchText() {
		System.out.println("getSearchText : " + searchText);
		return searchText;
	}

	public void setSearchText(String searchText) {
		System.out.println("setSearchText : " + searchText);
		this.searchText = searchText;
	}

	public void onSearch() {
		setSearchValueDisplay(searchText);
		incrementTagForSearch();
	}

	private void incrementTagForSearch() {
		if ("".equals(searchText)) {
			return;
		}

		TagCloudItem searchValueTagCloudItem = null;
		for (TagCloudItem tagCloudItem : tagCloudBean.getModel().getTags()) {
			if (tagCloudItem.getLabel().equals(searchText)) {
				searchValueTagCloudItem = tagCloudItem;
				if (searchValueTagCloudItem.getStrength() == 5) {
					return;
				}
				break;
			}
		}

		int countTag = 0;
		if (searchValueTagCloudItem != null) {
			countTag = searchValueTagCloudItem.getStrength();
			tagCloudBean.getModel().removeTag(searchValueTagCloudItem);
		}
		countTag++;
		tagCloudBean.getModel().addTag(new MyTagCloudItem(searchText, countTag));
	}

	public void onSelectTag(SelectEvent event) {
		TagCloudItem item = (TagCloudItem) event.getObject();
		searchText = item.getLabel();
		searchValueDisplay = item.getLabel();
	}

	public TagCloudBean getTagCloudBean() {
		return tagCloudBean;
	}

	public void setTagCloudBean(TagCloudBean tagCloudBean) {
		this.tagCloudBean = tagCloudBean;
	}

	public String getSearchValueDisplay() {
		return searchValueDisplay;
	}

	public void setSearchValueDisplay(String searchValueDisplay) {
		this.searchValueDisplay = searchValueDisplay;
	}

}
