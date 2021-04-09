package hust.soict.globalict.aims;
import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.store.*;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import java.util.Scanner;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new cart
		Cart anOrder = new Cart();
		Store aStore = new Store();
		
		// Create a new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		aStore.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "Geogre Lucas", 87, 24.95f);
		aStore.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		aStore.addMedia(dvd3);
		
		//anOrder.removeDigitalVideoDisc(dvd2);
		
		//System.out.println(anOrder.getQtyOrdered());
		
		
		//Print total cost of the order
		//System.out.println("Total cost is:");
		//System.out.println(anOrder.totalCost());
		
		
		
		Scanner scan = new Scanner(System.in);
		int choice, choice1,choice2;
		do {
			showMenu();
			System.out.println("Your choice: ");
			choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 1:
				do {
					storeMenu();
					System.out.println("Your choice: ");
					choice1 = scan.nextInt();
					switch(choice1) {
					case 1:
						aStore.printStore();
						break;
					case 2:
						System.out.println("Enter ID: ");
						int id = scan.nextInt();
						scan.nextLine();
						if(aStore.searchByID(id) != null) {
							anOrder.addMedia(aStore.searchByID(id));
							System.out.println("The number of media is: "+ anOrder.getQtyOrdered());
						}else {
							System.out.println("No match is found");
						}
						break;
					case 3:
                        anOrder.printList();
						break;
					case 0:
						break;
					default:
						System.out.println("Invalid choice ");
					}
				}while(choice1 != 0);
				break;
			case 2:
				do {
					System.out.println("--------------------");
					System.out.println("Options: ");
					System.out.println("1. Add DVD into Store");
					System.out.println("2. Remove DVD from Store");
					System.out.println("0. Exit");
					System.out.println("--------------------");
					System.out.println("Your choice: ");
					choice1 = scan.nextInt();
					scan.nextLine();
					switch(choice1) {
					case 1:
						//title , category , director, length,cost
						System.out.println("Enter Title:");
						String title = scan.nextLine();
						System.out.println("Enter Category:");
						String category = scan.nextLine();
						System.out.println("Enter Director:");
						String director = scan.nextLine();
						System.out.println("Enter Length:");
						int length = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter Cost:");
						float cost = scan.nextFloat();
						DigitalVideoDisc dvd = new DigitalVideoDisc(title,category,director,length,cost);
						aStore.addMedia(dvd);
						aStore.printStore();
						break;
					case 2:
						System.out.println("Enter ID: ");
						int id = scan.nextInt();
						scan.nextLine();
						if(aStore.searchByID(id) != null) {
							aStore.removeMedia(id);
						}else {
							System.out.println("No match is found");
						}
						aStore.printStore();
						break;
					case 0:
						break;
					default:
						System.out.println("Invalid choice ");
					}
				}while(choice1 != 0);
				break;
			case 3: 
				do {
					cartMenu();
					System.out.println("Your choice: ");
					choice1 = scan.nextInt();
					scan.nextLine();
					switch(choice1) {
					case 1:
						do {
							System.out.println("Options: ");
							System.out.println("--------------------");
							System.out.println("1. Filter DVDs by Id");
							System.out.println("2. Filter DVDs by Title ");
							System.out.println("0. Exit");
							System.out.println("--------------------");	
							System.out.println("Your choice: ");
							choice2 = scan.nextInt();
							scan.nextLine();
							switch(choice2) {
							case 1:
								System.out.println("Enter ID: ");
								int id = scan.nextInt();
								scan.nextLine();
								anOrder.searchByID(id);
								break;
							case 2:
								System.out.println("Enter Title:");
								String title = scan.nextLine();
								anOrder.searchByTitle(title);
								break;
							case 0:
								break;
							default:
								System.out.println("Invalid choice ");
							}
						}while(choice2 != 0);
						break;
					case 2:
						anOrder.printList();
						break;
					case 3:
						System.out.println("Enter ID: ");
						int id = scan.nextInt();
						scan.nextLine();
						anOrder.removeMedia(id);
						anOrder.printList();
						break;
					case 4:
						anOrder.getLuckyItem();
						anOrder.printList();
						break;
					case 5:
						System.out.println("An order is created!");
						anOrder.placeOrder();
						break;
					case 0:
						break;
					default:
						System.out.println("Invalid choice ");
					}
				}while(choice1 != 0);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice ");
			}
		}while(choice != 0);
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store ");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------");
		System.out.println("1. See a Media's details");
		System.out.println("2. Add a Media to cart");
		System.out.println("3. See current cart ");
		System.out.println("0. Exit");
		System.out.println("--------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove medias from cart ");
		System.out.println("4. Get a lucky item from cart ");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

}
