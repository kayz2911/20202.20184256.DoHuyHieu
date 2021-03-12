
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
			qtyOrdered--;
			
		}
		else System.out.println("The cart is empty");
	}
	
	public float totalCost() {
		for(int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
}
