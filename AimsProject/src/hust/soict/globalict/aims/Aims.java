package hust.soict.globalict.aims;
import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import Threads.MemoryDaemon;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new cart
		Thread thread = new Thread(new MemoryDaemon());
		thread.setDaemon(true);
		
		
		
		Cart anOrder = new Cart();
		Store aStore = new Store();
		//MemoryDaemon memory = new MemoryDaemon();
		
		
		// Create a new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f); // -87
		aStore.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "Geogre Lucas", 87, 24.95f);
		aStore.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		aStore.addMedia(dvd3);
		
		Track track1 = new Track("A",1);
		Track track2 = new Track("B",20);
		Track track3 = new Track("C",3); //-3  
		
		CompactDisc dvd4 = new CompactDisc("Lion Star","Animation","Geogre", 14, 31.2f);
		dvd4.addTrack(track1);
		dvd4.addTrack(track2);
		dvd4.addTrack(track3);
		aStore.addMedia(dvd4);
		
		String author1 = "Lucas";
		String author2 = "Aller";
		Book book1 =  new Book("Book1","CategoryB",21f, "ContentA and D");
		book1.addAuthor(author1);
		book1.addAuthor(author2);
		aStore.addMedia(book1);	
		
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
							try {
								anOrder.addMedia(aStore.searchByID(id));
							} catch (LimitExceededException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("The number of media is: "+ anOrder.getQtyOrdered());
						}else {
							System.out.println("No match is found");
						}
						break;
					case 3:
						anOrder.printCart();
                        anOrder.seeCurrentCart();
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
					System.out.println("1. Add media into Store");
					System.out.println("2. Remove media from Store");
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
						System.out.println("Enter Cost:");
						float cost = scan.nextFloat();
						System.out.print(" Type of media: \n"
								+ "     1 - Book\n     2 - DVD\n     3 - CD");
						System.out.println("Your choice:");
						int mediaType = scan.nextInt();
						switch (mediaType) {
						case 1:
							ArrayList<String> authors = new ArrayList<String>();
							int nAuthors;
							String author, content;
							System.out.println("Enter number of authors: ");
							nAuthors = scan.nextInt();
							scan.nextLine();
							for(int i = 1; i <= nAuthors; i++) {
								System.out.println("Enter Author number " + i + ": ");
								author = scan.nextLine();
								authors.add(author);
							}
							System.out.println("Enter Content: ");
							content = scan.nextLine();
							aStore.addMedia(new Book(title, category, cost, authors, content));
							System.out.println(cost);
							break;
						case 2:
							System.out.println("Enter Director:");
							String director = scan.nextLine();
							System.out.println("Enter Length:");
							int length = scan.nextInt();
							scan.nextLine();
							aStore.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
							break;
						case 3:
							String  artist, trackTitle;
							ArrayList<Track> tracks = new ArrayList<Track>();
							int trackLength;
							
							System.out.print("Enter Director: ");
							director = scan.nextLine();
							System.out.print("Enter Length: ");
							length = scan.nextInt();
							System.out.print("Enter Artist: ");
							artist = scan.nextLine();
							System.out.print("Enter number of track: ");
							int nTracks = scan.nextInt();
							scan.nextLine();
							for(int i = 1; i <= nTracks; i++) {
								System.out.println("Track number " + i + ": ");
								System.out.print("Enter Title: ");
								trackTitle = scan.nextLine();
								System.out.println("Enter Length: ");
								trackLength = scan.nextInt();
								scan.nextLine();
								tracks.add(new Track(trackTitle, trackLength));
							}
							aStore.addMedia(new CompactDisc(title, category, director, length, cost, artist, tracks));
							break;
						default:
							break;
						}
						
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
							System.out.println("1. Filter media by Id");
							System.out.println("2. Filter media by Title ");
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
						do {
							System.out.println("Options: ");
							System.out.println("--------------------");
							System.out.println("1. Sort by title and category");
							System.out.println("2. Sort by title then by cost ");
							System.out.println("3. Sort by cost then by title ");
							System.out.println("0. Exit");
							System.out.println("--------------------");	
							System.out.println("Your choice: ");
							choice2 = scan.nextInt();
							scan.nextLine();
							switch(choice2) {
							case 1:
								//anOrder.sortByTitleandCategory();
								break;
							case 2:
								//anOrder.sortByTitleThenByCost();
								break;
							case 3:
								//anOrder.sortByCostthenByTitle();
								break;
							case 0:
								break;
							default:
								System.out.println("Invalid choice ");
							}
						}while(choice2 != 0);
						break;
					case 3:
						System.out.println("Enter ID: ");
						int id = scan.nextInt();
						scan.nextLine();
						anOrder.removeMedia(id);
						anOrder.sortByCost();
						break;
					case 4:
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
		//memory.run();
		thread.run();
		
		
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store ");
		System.out.println("3. View cart");
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
		System.out.println("4. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

}
