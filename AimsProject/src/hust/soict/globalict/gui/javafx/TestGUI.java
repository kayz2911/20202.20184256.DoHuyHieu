package hust.soict.globalict.gui.javafx;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.media.DigitalVideoDise;
import hust.soict.globalict.aims.order.Order;

public class TestGUI {

		public static void main(String[] args) {
			DigitalVideoDise dvd1 = new DigitalVideoDise("001","The Lion King", "Animation", 19.95f, "George Lucas", 124);
			DigitalVideoDise dvd2 = new DigitalVideoDise("002","Star Wars", "Sience Fiction",24.95f, "George Lucas", 124);
			DigitalVideoDise dvd3 = new DigitalVideoDise("003","Aladi", "Animation", 18.99f, "John MUsker", 90);
			
			try {
				Order order = new Order("001");
				order.addDisc(dvd1);
				order.addDisc(dvd2);
				order.addDisc(dvd3);
				new OrderScreen(order);
			} catch (LimitExceededException e) {
				
			}
		}

}
