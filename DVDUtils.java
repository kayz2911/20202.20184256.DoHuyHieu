
public class DVDUtils {

	public static String compareByCost(DigitalVideoDisc dvda, DigitalVideoDisc dvdb) {
		if(dvda.getCost() > dvdb.getCost()) {
			return "Cost DVD " + dvda.getTitle() + " bigger than DVD " + dvdb.getTitle() ;
		}
		else if(dvda.getCost() < dvdb.getCost()) {
			return "Cost DVD " + dvda.getTitle() + " smaller than DVD " + dvdb.getTitle();
		}
		else return "Two DVD cost are equal";
	}
	
	public static String compareByTitle(DigitalVideoDisc dvda, DigitalVideoDisc dvdb) {
		if(dvda.getTitle().compareTo(dvdb.getTitle()) == 1) {
			return "Title DVD " + dvda.getTitle() + " bigger than DVD " + dvdb.getTitle() ;
		}
		else {
			return "Title DVD " + dvda.getTitle() + " smaller than DVD " + dvdb.getTitle();
		}
		
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc [] sort) {
		for(int i = 0 ; i < sort.length-1; i++) {
			for(int j = 0; j < sort.length-i-1; j++ ) {
				if(sort[j].getCost() < sort[j+1].getCost()) {
					DigitalVideoDisc tmp = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = tmp;
				}
			}
		}
		return sort;
	}
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc [] sort) {
		for(int i = 0 ; i < sort.length-1; i++) {
			for(int j = 0; j < sort.length-i-1; j++ ) {
				if(sort[j].getTitle().compareTo(sort[j+1].getTitle()) == 1) {
					DigitalVideoDisc tmp = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = tmp;
				}
			}
		}
		return sort;
	}
	
}
