package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.*;


public class TestMediaToString {
	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		// create some media here
		// for example: cd, dvd, book 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King 2", "Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		Book book1 = new Book("Book1", "Action", 21f, "ContentA and D");
		Book book2 = new Book("Book2", "Comedy", 23f, "ContentB and C");
		

	
		
		mediae.add(dvd1);
		mediae.add(dvd2);
		mediae.add(dvd3);
		mediae.add(dvd4);
		mediae.add(book1);
		mediae.add(book2);
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
		
	}
}
