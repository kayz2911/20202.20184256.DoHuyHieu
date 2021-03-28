package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.disc.*;
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
	
	public DigitalVideoDisc searchByID1(int id) {
		for (DigitalVideoDisc item : itemsOrdered) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	
	public void searchByTitle (String title) {
		int flag = 0;
		for (int i = 0 ; i < qtyOrdered; i++) {
			if (itemsOrdered[i].search(title)) {
				flag = 1;
				System.out.println(itemsOrdered[i].getDetail());
			}
		}
		if (flag == 0) {
			System.out.println("No match is found");
		}
	}
	
	public void placeOrder() {
		for (int i = 0; i < qtyOrdered; i++) {
			itemsOrdered[i] = null;
		}
		System.out.println("An order is created ");
	}
	
	public void printAll() {
		if(qtyOrdered == 0) {
			System.out.println("Cart is empty");
		}else {
			for (int i = 0; i < qtyOrdered; i++) {
				System.out.println(itemsOrdered[i].getDetail());	
			}
		}
	}
	
	public void printList() {
		DigitalVideoDisc[] sort = itemsOrdered;
		for (int i = 0; i <  qtyOrdered - 1; i++) {
			for (int j = i+1; j < qtyOrdered ; j++) {
				if (sort[i].getTitle().compareTo(sort[j].getTitle()) > 0) {
					DigitalVideoDisc tmp = sort[i];
					sort[i] = sort[j];
					sort[j] = tmp;
				}else if (sort[i].getTitle().compareTo(sort[j].getTitle()) == 0) {
					if (sort[i].getCost() < sort[j].getCost()) {
						DigitalVideoDisc tmp = sort[i];
						sort[i] = sort[j];
						sort[j] = tmp;
					}else if (sort[i].getCost() == sort[j].getCost()) {
						if (sort[i].getLength() < sort[j].getLength()) {
							DigitalVideoDisc tmp = sort[i];
							sort[i] = sort[j];
							sort[j] = tmp;
						}
					}
				}
			}	
		}
		System.out.println("***************CART**********");
		System.out.println("Ordered Items:");
		for (int i = 0 ; i < qtyOrdered; i++) {
			System.out.println(sort[i].getDetail());
		}
		System.out.printf("Total cost: %.2f \n",totalCost());
		System.out.println("*************************");
	}
	
}
