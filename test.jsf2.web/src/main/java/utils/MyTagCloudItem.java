package utils;

import org.primefaces.model.tagcloud.DefaultTagCloudItem;

public class MyTagCloudItem extends DefaultTagCloudItem {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean equals(Object obj) {
		MyTagCloudItem compared = (MyTagCloudItem) obj;
		if (compared.getLabel().equals(this.getLabel())) {
			return true;
		}

		return false;
	}
	
	public MyTagCloudItem(String label, int strength){
		super(label, "#", strength);
	}

}
