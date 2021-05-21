package hust.soict.globalict.aims;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.media.DigitalVideoDise;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.order.Order;

public class DiskTest {

	public static void main(String[] args) {
		DigitalVideoDise dvd1 = new DigitalVideoDise("001","The Lion King", "Animation", 19.95f, "George Lucas", 124);
		
		boolean search = dvd1.search("The King");
		System.out.println(search);	
		
		DigitalVideoDise dvd2 = new DigitalVideoDise("002","Star Wars", "Sience Fiction",24.95f, "George Lucas", 124);
		DigitalVideoDise dvd3 = new DigitalVideoDise("003","Aladi", "Animation", 18.99f, "John MUsker", 90);
		
		try {
			Order anOrder = new Order("111");
			anOrder.addDisc(dvd1);
			anOrder.addDisc(dvd2);
			anOrder.addDisc(dvd3);
			
			System.out.print("Total Cost is: ");
			System.out.println(anOrder.totalCost());
			
			try {
				Media luckyItem = anOrder.getALuckyItem();
				System.out.println("The title of luckey item is: " + luckyItem.getTitle());
				System.out.println("The total cost after pick a lucky item is: " + anOrder.totalCost());
			} catch (NullPointerException e) {
				System.out.println("Good Luck next time");
			}
			
		} catch (LimitExceededException e) {
			System.out.println("ERROR. Can not create new order.");
		}
	}

}
