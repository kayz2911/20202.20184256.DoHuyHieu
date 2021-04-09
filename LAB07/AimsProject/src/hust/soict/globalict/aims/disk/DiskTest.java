package hust.soict.globalict.aims.disk;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
public class DiskTest {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEA", "eeee", "eeee", 5, 3.3f);
		
		anOrder.addMedia(dvd1);
		anOrder.addMedia(dvd2);
		anOrder.addMedia(dvd3);
		anOrder.addMedia(dvd4);
		anOrder.addMedia(dvd5);
		
		anOrder.searchByTitle("A");
		anOrder.searchByTitle("F");
		
	}
}
