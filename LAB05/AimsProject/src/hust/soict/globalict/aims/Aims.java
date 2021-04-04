package hust.soict.globalict.aims;


import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import java.util.Scanner;
public class Aims {
	public static void  main(String[] args) {
		Cart anOrder = new Cart();
		Store aStore = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		aStore.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		aStore.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		aStore.addDVD(dvd3);
		//anOrder.printCart();
		//System.out.println("The total is: ");
		//System.out.printf("%.2f\n\n", anOrder.totalCost());
		
		//anOrder.removeDigitalVideoDisc(dvd2);
		
		//anOrder.removeDigitalVideoDisc(dvd3);

		
		//System.out.println("The quantity of DVDs is: ");
		//System.out.println(anOrder.qtyOrdered());
		
		
		//System.out.println("The total is: ");
		//System.out.printf("%.2f\n", anOrder.totalCost());
		//anOrder.printCart();
		Scanner sc = new Scanner(System.in);
		int choice, choice1,choice2;
		do {
			showMenu();
			System.out.println("Your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				do {
					storeMenu();
					System.out.println("Your choice: ");
					choice1 = sc.nextInt();
					switch(choice1) {
					case 1:
						aStore.printStore();
						break;
					case 2:
						System.out.println("Enter ID: ");
						int id = sc.nextInt();
						sc.nextLine();
						if(aStore.searchByID(id) != null) {
							anOrder.addDigitalVideoDisc(aStore.searchByID(id));
							System.out.printf("The number of DVDs is: %d ",anOrder.getQtyOrdered());
						}else {
							System.out.println("No match is found");
						}
						break;
					case 3:
                        anOrder.printAll();
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
					System.out.println("1. Add DVD into Store: ");
					System.out.println("2. Remove DVD from Store");
					System.out.println("0. Exit");
					System.out.println("Your choice: ");
					System.out.println("--------------------");
					choice1 = sc.nextInt();
					sc.nextLine();
					switch(choice1) {
					case 1:
						//title , category , director, length,cost
						System.out.println("Enter Title:");
						String title = sc.nextLine();
						System.out.println("Enter Category:");
						String category = sc.nextLine();
						System.out.println("Enter Director:");
						String director = sc.nextLine();
						System.out.println("Enter Length:");
						int length = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Cost:");
						float cost = sc.nextFloat();
						DigitalVideoDisc dvd = new DigitalVideoDisc(title,category,director,length,cost);
						aStore.addDVD(dvd);
						aStore.printStore();
						break;
					case 2:
						System.out.println("Enter ID: ");
						int id = sc.nextInt();
						sc.nextLine();
						if(aStore.searchByID(id) != null) {
							aStore.removeDVD(aStore.searchByID(id));
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
					choice1 = sc.nextInt();
					sc.nextLine();
					switch(choice1) {
					case 1:
						do {
							System.out.println("Options: ");
							System.out.println("--------------------");
							System.out.println("1. Filter DVDs by Id");
							System.out.println("2. Filter DVDs by Title ");
							System.out.println("0. Exit");
							System.out.println("--------------------");
							choice2 = sc.nextInt();
							sc.nextLine();
							switch(choice2) {
							case 1:
								System.out.println("Enter ID: ");
								int id = sc.nextInt();
								sc.nextLine();
								DigitalVideoDisc item = anOrder.searchByID1(id);
								System.out.println(item.getDetail());
								break;
							case 2:
								System.out.println("Enter Title:");
								String title = sc.nextLine();
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
						int id = sc.nextInt();
						sc.nextLine();
						anOrder.removeDigitalVideoDisc(anOrder.searchByID1(id));
						anOrder.printList();
						break;
					case 4:
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
		System.out.println("1. See a DVD's details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart ");
		System.out.println("0. Exit");
		System.out.println("--------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart ");
		System.out.println("4. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
}
