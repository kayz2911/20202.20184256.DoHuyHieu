package hust.soict.globalict.test.store;
import hust.soict.globalict.aims.disc.*;
import hust.soict.globalict.aims.store.*;
public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store aStore = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		aStore.addDVD(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		aStore.addDVD(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		aStore.addDVD(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		aStore.addDVD(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		aStore.addDVD(dvd5);
		
		aStore.removeDVD(dvd5);
		
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
