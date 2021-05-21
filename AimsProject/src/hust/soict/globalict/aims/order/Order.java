package hust.soict.globalict.aims.order;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDise;
import hust.soict.globalict.aims.media.Media;
import javafx.collections.ObservableList;

public class Order {

	public static final int MAX_LIMITED_ORDERS = 5;
	public static final int MAX_NUMBERS_ORDERED = 10;
	private Date dateOrdered;
	private String id;
	private  static int nbOrders = 0;
	private List<Media> itemsOrdered = new ArrayList<Media>(); 
	
	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public List<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public ObservableList<Media> getItemsOrderList() {
		ObservableList<Media> itemsOrderList = javafx.collections.FXCollections.observableArrayList();
		for (Media media : itemsOrdered ) {
			itemsOrderList.add(media);
		}
		return itemsOrderList;
	}

	public void setItemsOrdered(List<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public Order(String id) throws LimitExceededException{
		if ( nbOrders < MAX_LIMITED_ORDERS ) {
			this.dateOrdered =  new Date();
			this.id = id;
			Order.nbOrders = Order.nbOrders + 1;
			System.out.println("A new order is created");
		}
		else {
			throw new LimitExceededException("ERROR: The number of orders has reached its limit!");
		}
	}
	
	public void addBook(Book book) {
		if ( itemsOrdered.size() < MAX_NUMBERS_ORDERED ) {
			if ( !itemsOrdered.contains(book) ) {
				itemsOrdered.add(book);
			}
		}
		else {
			System.out.println("The number of orders created is maximum");
		}
	}
	
	public void addDisc(DigitalVideoDise disc) {
		if ( itemsOrdered.size() < MAX_NUMBERS_ORDERED ) {
			if ( !itemsOrdered.contains(disc) ) {
				itemsOrdered.add(disc);
			}
		}
		else {
			System.out.println("The number of orders created is maximum");
		}
	}
	
	public void addCompactDisc(CompactDisc cd) {
		if ( itemsOrdered.size() < MAX_NUMBERS_ORDERED ) {
			if ( !itemsOrdered.contains(cd) ) {
				itemsOrdered.add(cd);
			}
		}
		else {
			System.out.println("The number of orders created is maximum");
		}
	}
	
	public void removeMedia( Media media ) {
		if ( itemsOrdered.contains(media )) {
			itemsOrdered.remove(media);
		}
		else {
			System.out.println("This media doesn't exist in order");
		}
	}

	public float totalCost( ) {
		float sum = 0f;
		
		for ( Media media: itemsOrdered ) {
			sum += media.getCost();
		}
		return sum;
	}

	public Media findMedia(String id) {
		for ( Media media : itemsOrdered ) {
			if ( media.getId().contentEquals(id) ) {
				return media;
			}
		}
		System.out.println("Item doesn't exist in order");
		return null;
	}
	
	public void deleteById(String id) {
		Media media = findMedia(id);
		itemsOrdered.remove(media);
	}
	
	public void printAnOrder() {
		System.out.println("**********************Order***********************");
		System.out.println("ID: " + getId());
		System.out.println("Odered Items: ");
		for ( int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println("Item " + (i+1) );
			itemsOrdered.get(i).printMedia();
		}
		System.out.println("Total Cost: " + totalCost());
		System.out.println("*************************************************");	
	}
	
	public Media getALuckyItem() {
		float threshold1 = 500f;
		float threshold2 = 1000f;
		Media luckyMedia;
		if ( this.totalCost() >= threshold1 && this.itemsOrdered.size() >= 7 ) {
			do {
			int luckyNumber = (int)( Math.random() * (itemsOrdered.size() -1 ));
			luckyMedia = itemsOrdered.get(luckyNumber);
			} while (luckyMedia.getCost() <= threshold1/7);
			luckyMedia.setCost(0f);
			return luckyMedia;
		}
		else if ( this.totalCost() >= threshold2 && this.itemsOrdered.size() >= 10 ) {
			do {
				int luckyNumber = (int)( Math.random() * (itemsOrdered.size() -1 ));
				luckyMedia = itemsOrdered.get(luckyNumber);
			} while (luckyMedia.getCost() <= threshold2/10);
			luckyMedia.setCost(0f);
			return luckyMedia;
		}
		return null;

	}
}
