package org.rcx.test.jsf2.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.rcx.test.jsf2.metier.service.IMetier;
import org.rcx.test.jsf2.persistence.entity.FavTrend;
import org.rcx.test.jsf2.web.pfbean.TagCloudBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import utils.MyTagCloudItem;

public class Search implements Serializable {

	private static final long serialVersionUID = 1L;

	private String searchValue;

	private TagCloudBean tagCloudBean;

	private IMetier metier;

	public String getSearchValue() {
		return searchValue;
	}

	@PostConstruct
	private void beforeFirstRender() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-metier-dao.xml");
		metier = (IMetier) ctx.getBean("metier");
		List<FavTrend> favTrends = metier.getAllFavTrend();
		
		for (FavTrend favTrend : favTrends) {
			tagCloudBean.getModel().addTag(new MyTagCloudItem(favTrend.getValue(), 3));
		}
		
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public void onSearch() {
		incrementTagForSearch();
		searchForResults();
	}

	private void searchForResults() {
		metier.getTwittsBySearch(searchValue);
		
	}

	private void incrementTagForSearch() {
		if ("".equals(searchValue)) {
			return;
		}

		TagCloudItem searchValueTagCloudItem = null;
		for (TagCloudItem tagCloudItem : tagCloudBean.getModel().getTags()) {
			if (tagCloudItem.getLabel().equals(searchValue)) {
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
		tagCloudBean.getModel().addTag(new MyTagCloudItem(searchValue, countTag));
	}

	public void onSelectTag(SelectEvent event) {
		TagCloudItem item = (TagCloudItem) event.getObject();
		searchValue = item.getLabel();
	}

	public TagCloudBean getTagCloudBean() {
		return tagCloudBean;
	}

	public void setTagCloudBean(TagCloudBean tagCloudBean) {
		this.tagCloudBean = tagCloudBean;
	}

}
