
public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create a new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "Geogre Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		anOrder.removeDigitalVideoDisc(dvd2);
		
		//System.out.println(anOrder.getQtyOrdered());
		
		
		//Print total cost of the order
		System.out.println("Total cost is:");
		System.out.println(anOrder.totalCost());
		
	}

}
