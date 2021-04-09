package hust.soict.globalict.aims.media;

import java.time.LocalDate;

abstract public class Media {
	public static int nbMedia = 1;
	public int id;
	public String title;
	public String category;
	public float cost;
	public LocalDate dateAdded;
	
	
	public int getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public Media() {
		this.id = nbMedia++;
		dateAdded = LocalDate.now();
	}
	
	public Media(String title) {
		super();
		this.title = title;
		this.id = nbMedia++;
		dateAdded = LocalDate.now();
	}
	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbMedia++;
		dateAdded = LocalDate.now();
	}
	
	public String getDetail() {
		return id + ".DVD " + title + " - " + category + " - " + ": " + cost +" $";
	}
	
	public boolean search(String title) {
		String caseInsensitive = this.title.toLowerCase();
		title = title.toLowerCase();
		return caseInsensitive.contains(title);
	}
	
	

}
