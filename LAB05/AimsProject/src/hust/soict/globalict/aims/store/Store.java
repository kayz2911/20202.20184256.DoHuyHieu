package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
public class Store {
	public static final int MAX_NUMBER_DVD = 2000;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBER_DVD];
	public int qtyOrdered = 0;
	
	public int getQtyOrdered(){
		return qtyOrdered;
	}
	
	public void addDVD(DigitalVideoDisc disc) {
		if(qtyOrdered <= MAX_NUMBER_DVD) {
			qtyOrdered++;
			itemsInStore[qtyOrdered - 1] = disc;
			System.out.println("The disc "+ disc.getTitle() +" has been added");
		}
		else System.out.println("The cart is almost full");
	}
	public void removeDVD(DigitalVideoDisc disc) {
		if(qtyOrdered > 0) {
			for(int i = 0; i < qtyOrdered; i++) {
				if (itemsInStore[i] == disc) {
					for(int j = i; j < qtyOrdered - 1; j++) {
						itemsInStore[j] = itemsInStore[j+1];
					}
					qtyOrdered--;
				}
			}
			System.out.println("The disc "+ disc.getTitle() +" has been removed");
		}
		else System.out.println("The cart is empty");
	}
	public void printStore() {
		
		System.out.println("**********STORE**********");
		System.out.println("Ordered Items:");
		for (int i = 0 ; i < qtyOrdered; i++) {
			System.out.println(itemsInStore[i].getDetail());
		}
		System.out.println("*************************");
	}
	
	public DigitalVideoDisc searchByID(int id) {
		for (DigitalVideoDisc item : itemsInStore) {
			if (item.getID() == id) {
				return item;
			}
		}
		return null;
	}
}
