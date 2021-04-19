package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.*;

public class TestMediaCompareTo {
	public static void  main(String[] args) {
		Collection collection = new java.util.ArrayList<>();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
				
		
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);

		
		Iterator iterator = collection.iterator();
		
		System.out.println("-------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
        Collections.sort((List)collection);
		
		iterator = collection.iterator();
		System.out.println("-------------------");
		System.out.println("The DVDs in sorted order are: ");
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).toString());
		}
		System.out.println("-------------------");
		
		Collections.sort((List)collection, Media.COMPARE_BY_COST_TITLE);
		
		iterator = collection.iterator();
		System.out.println("-------------------");
		System.out.println("The DVDs in sorted order are: ");
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).toString());
		}
		System.out.println("-------------------");
		
        Collections.sort((List)collection, Media.COMPARE_BY_TITLE_COST);
		
		iterator = collection.iterator();
		System.out.println("-------------------");
		System.out.println("The DVDs in sorted order are: ");
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).toString());
		}
		System.out.println("-------------------");
		
		System.out.println("The DVDs currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
	}
	
}
