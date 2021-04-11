package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public Book (String title, String category, float cost) {
		super(title,category,cost);
	}
	
	public Book(String title, String category, float cost, List<String> authors) {
		super(title,category,cost);
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName){
		int flag = 0;
		for(String author : authors) {
			if(author.compareTo(authorName) == 0) {
				System.out.println("The author has been exist");
				flag = 1;
			}
		}
		if(flag == 0) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName){
		int flag = 0;
		for(String author : authors) {
			if(author.compareTo(authorName) != 0) {
				System.out.println("The author has not been exist");
				flag = 1;
			}
		}
		if(flag == 0) {
			authors.remove(authorName);
		}
	}
	
	public void play() {
		super.play();
		System.out.println("Can not play a book");
	}
	
	public String getDetail() {
		return id + ".Book " + title + " - " + category  + "- " + cost +"$" + "-" + authors;
	}

}
