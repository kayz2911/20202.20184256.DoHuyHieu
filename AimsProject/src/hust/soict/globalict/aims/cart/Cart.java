package hust.soict.globalict.aims.cart;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered = 0;
	public float cost = 0;
	
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered <= MAX_NUMBER_ORDERED) {
			qtyOrdered++;
			itemsOrdered[qtyOrdered - 1] = disc;
			System.out.println("The disc "+ disc.getTitle() +" has been added");
		}
		else System.out.println("The cart is almost full");
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered > 0) {
			for(int i = 0; i < qtyOrdered; i++) {
				if (itemsOrdered[i] == disc) {
					for(int j = i; j < qtyOrdered - 1; j++) {
						itemsOrdered[j] = itemsOrdered[j+1];
					}
					qtyOrdered--;
				}
			}
			System.out.println("The disc "+ disc.getTitle() +" has been removed");
		}
		else System.out.println("The cart is empty");
	}
	
	public float totalCost() {

		for(int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (int i = 0 ;i < dvdList.length; i++) {
			addDigitalVideoDisc(dvdList[i]);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[]  disc) {
		for(int i = 0 ; i < disc.length - 1; i++) {
			for(int j = 0; j < disc.length-i-1; j++ ) {
				if(disc[j].getCost() < disc[j+1].getCost()) {
					DigitalVideoDisc tmp = disc[j];
					disc[j] = disc[j+1];
					disc[j+1] = tmp;
				}
			}
		}
		return disc;
	}
	
	public static DigitalVideoDisc[]  sortByTitle(DigitalVideoDisc[] disc) {
		for(int i = 0 ; i < disc.length-1; i++) {
			for(int j = 0; j < disc.length-i-1; j++ ) {
				if(disc[j].getTitle().compareTo(disc[j+1].getTitle()) == 1) {
					DigitalVideoDisc tmp = disc[j];
					disc[j] = disc[j+1];
					disc[j+1] = tmp;
				}
			}
		}
		return disc;
	}
	
	public static DigitalVideoDisc[] sortByLength(DigitalVideoDisc[] disc) {
		for(int i = 0 ; i < disc.length-1; i++) {
			for(int j = 0; j <disc.length-i-1; j++ ) {
				if(disc[j].getLength() < disc[j+1].getLength()) {
					DigitalVideoDisc tmp = disc[j];
					disc[j] = disc[j+1];
					disc[j+1] = tmp;
				}
			}
		}
		return disc;
	}
	
	public static DigitalVideoDisc searchById(DigitalVideoDisc[] disc,int id) {
		for(int i = 0; i < disc.length; i++) {
			if (id == disc[i].getId()) {
				return disc[i];
			}
		}
		return null;
	}
	
	public static float total(DigitalVideoDisc[] disc) {
		float sum = 0;
		for(int i = 0; i < disc.length; i++) {
			sum += disc[i].getCost();
		}
		return sum;
	}
}
