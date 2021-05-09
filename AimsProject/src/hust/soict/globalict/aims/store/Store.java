package hust.soict.globalict.aims.store;
import java.util.ArrayList;
import hust.soict.globalict.aims.media.*;
public class Store {
	public static final int MAX_NUMBER_DVD = 2000;
	private ArrayList<Media>  itemsInStore = new ArrayList<Media>();
	
	
	public void addMedia(Media media){
		int flag = 0;
		for(Media item : itemsInStore) {
			if(item.equals(media)) {
				System.out.println("The media has been exist");
				flag = 1;
			}
		}
		if(flag == 0) {
			itemsInStore.add(media);
		}
	}
	
	public void removeMedia(Media media){
		int flag = 0;
		for(Media item : itemsInStore) {
			if(!item.equals(media)) {
				System.out.println("The author has not been exist");
				flag = 1;
			}
		}
		if(flag == 0) {
			itemsInStore.remove(media);
		}
	}
	
	public void removeMedia(int id) {
		int number = -1;
		for (int i = 0 ; i <  itemsInStore.size(); i++)
		{
			if ( itemsInStore.get(i).getID() == id)
			{
				number = i;
				break;
			}
		}
		if (number == -1) {
			System.out.println("The id does not exist");
		}else {
			for (int i = number ; i <  itemsInStore.size()-1; i++)
			{
				 itemsInStore.set(i,  itemsInStore.get(i+1));
			}
		}
		 itemsInStore.remove( itemsInStore.size()-1);
		System.out.println("The media is removed");
	}
	
	public void printStore() {
		
		System.out.println("**********STORE**********");
		System.out.println("Ordered Items:");
		for (int i = 0 ; i < itemsInStore.size(); i++) {
			System.out.println(itemsInStore.get(i).toString());
		}
		System.out.println("*************************");
	}
	
	public Media searchByID(int id) {
		for (Media item : itemsInStore) {
			if (item.getID() == id) {
				return item;
			}
		}
		return null;
	}
	
	public ArrayList<Media> getItemsInStore() {
		ArrayList<Media> mediaInStore = new ArrayList<Media>();
		for (Media item : itemsInStore) {
			mediaInStore.add(item);
		}
		return mediaInStore;
	}
}
