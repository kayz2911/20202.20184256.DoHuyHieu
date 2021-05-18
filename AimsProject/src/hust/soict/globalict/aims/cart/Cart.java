package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Scanner;




public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	public ObservableList<Media> itemsOrdered =  FXCollections.observableArrayList();
	
    public boolean isEmpty() {
        return itemsOrdered.isEmpty();
    }
    
    public int getQtyOrdered() {
    	return itemsOrdered.size();    
    }
	
	public float totalCost() {
		float sum = 0;
		for(int i = 0;i<itemsOrdered.size();i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	public void addMedia(Media media) {
		if(itemsOrdered.size() == 20) {
			System.out.println("The Cart is almost full");
		}else {
			itemsOrdered.add(media);
			System.out.println("The media "+ media.getTitle() +" has been added");
		}
	}
	
	public void removeMedia() {
		if (itemsOrdered.size() >0) {
			itemsOrdered.remove(itemsOrdered.size()-1);
		}
	}
	
	public void removeMedia(Media media) {
		if(itemsOrdered.size() == 0) {
			System.out.println("The Cart is empty");
		}else {
			itemsOrdered.remove(media);
			System.out.println("The media "+ media.getTitle() +" has been removed");
		}
	}
	
	public void removeMedia(int id) {
		int number = -1;
		for (int i = 0 ; i < itemsOrdered.size(); i++)
		{
			if (itemsOrdered.get(i).getID() == id)
			{
				number = i;
				break;
			}
		}
		if (number == -1) {
			System.out.println("The id does not exist");
		}else {
			for (int i = number ; i < itemsOrdered.size()-1; i++)
			{
				itemsOrdered.set(i, itemsOrdered.get(i+1));
			}
		}
		itemsOrdered.remove(itemsOrdered.size()-1);
		System.out.println("The media is removed");
	}
	
	public void printCart() {
		System.out.println("Your Cart: ");
		for (Media item : itemsOrdered) {
			if (item != null) {
				System.out.println(item.getID() + "." + item.getTitle());
			}
		}
	}
	
	
    public void searchByID(int id) {
		System.out.println("Search ID: ");
		int flag = 0;
		for (int i = 0 ; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getID() == id) {
				flag = 1;
				System.out.println(itemsOrdered.get(i).toString());
			}
		}
		if (flag == 0) {
			System.out.println("Do not find id");
		}
	}

    public void searchByTitle(String title) {
    	System.out.println("Search Title: ");
		int flag = 0;
		for (int i = 0 ; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).search(title)) {
				flag = 1;
				System.out.println(itemsOrdered.get(i).toString());
			}
		}
		if (flag == 0) {
			System.out.println("No match is found");
		}
    }
	
	public void placeOrder() {
        itemsOrdered.clear();
    }
	
	public void sortByTitle() {
		ObservableList<Media>  sort = itemsOrdered;
		for (int i = 0; i <  itemsOrdered.size() - 1; i++) {
			for (int j = i+1; j < itemsOrdered.size() ; j++) {
				if (sort.get(i).getTitle().compareTo(sort.get(j).getTitle()) > 0) {
					Media tmp = sort.get(i);
					sort.set(i,sort.get(j));
					sort.set(j,tmp);
				}else if (sort.get(i).getTitle().compareTo(sort.get(j).getTitle()) == 0) {
					if (sort.get(i).getCost() < sort.get(j).getCost()) {
						Media tmp = sort.get(i);
						sort.set(i,sort.get(j));
						sort.set(j,tmp);
					}
				}
			}	
		}
		System.out.println("***********CART**********");
		System.out.println("Ordered Items:");
		for (int i = 0 ; i < itemsOrdered.size(); i++) {
			System.out.println(sort.get(i).toString());
		}
		System.out.printf("Total cost: %.2f \n",totalCost());
		System.out.println("*************************");
	}
	
	public void sortByCost() {
		ObservableList<Media>  sort = itemsOrdered;
		for (int i = 0; i <  itemsOrdered.size() - 1; i++) {
			for (int j = i+1; j < itemsOrdered.size() ; j++) {
				if (sort.get(i).getCost() < sort.get(j).getCost()) {
					Media tmp = sort.get(i);
					sort.set(i,sort.get(j));
					sort.set(j,tmp);
				}else if (sort.get(i).getCost() == sort.get(j).getCost()) {
					if (sort.get(i).getTitle().compareTo(sort.get(j).getTitle()) > 0) {
						Media tmp = sort.get(i);
						sort.set(i,sort.get(j));
						sort.set(j,tmp);
					}
				}
			}	
		}
		System.out.println("***********CART**********");
		System.out.println("Ordered Items:");
		for (int i = 0 ; i < itemsOrdered.size(); i++) {
			System.out.println(sort.get(i).toString());
		}
		System.out.printf("Total cost: %.2f \n",totalCost());
		System.out.println("*************************");
	}
	
	
	public void seeCurrentCart(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Choose id media to play:");
		int id = scan.nextInt();
		int flag = 0;
		for(Media item : itemsOrdered) {
			if(item.getID() == id) {
				item.play();
				flag = 1;
			}
		}
		if(flag == 0) {
			System.out.println("Can not match this id");
		}

	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}	
	
	
}
	
	





