package org.rcx.test.jsf2.web;

import javax.faces.model.ArrayDataModel;

import org.primefaces.model.SelectableDataModel;
import org.rcx.test.jsf2.persistence.entity.FavTrend;

public class MyDataModel extends ArrayDataModel<FavTrend> implements
		SelectableDataModel<FavTrend> {

	public MyDataModel() {
	}

	public MyDataModel(FavTrend[] favTrends) {
		super(favTrends);
	}

	@Override
	public FavTrend getRowData(String rowKey) {
		FavTrend[] creneauxMedecinJour = (FavTrend[]) getWrappedData();
		int key = Integer.parseInt(rowKey);
		for (FavTrend favTrend : creneauxMedecinJour) {
			if (favTrend.getId() == key) {
				return favTrend;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(FavTrend favTrend) {
		return favTrend.getId();
	}
}
