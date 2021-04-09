package hust.soict.globalict.test.store;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.*;
public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store aStore = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		aStore.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		aStore.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		aStore.addMedia(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		aStore.addMedia(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		aStore.addMedia(dvd5);
		
		aStore.removeMedia(dvd5);
		
		int id = 4 ;
		if(aStore.searchByID(id) == null) {
			System.out.println("No match");
		}else {
			System.out.println("Yes");
		}
				
				
		//Print total cost of the order
		aStore.printStore();
	}

}
