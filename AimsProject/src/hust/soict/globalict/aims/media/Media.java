package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

import hust.soict.globalict.aims.exception.PlayerException;

abstract public class Media implements Comparable<Media> {
	public static int nbMedia = 1;
	public int id;
	public String title;
	public String category;
	public float cost;
	public LocalDate dateAdded;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
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
	
	@Override
	public String toString() {
		return id + ".DVD "  + " " + title + " - " + category + " - " + ": " + cost +" $";
	}
	
	public boolean search(String title) {
		String caseInsensitive = this.title.toLowerCase();
		title = title.toLowerCase();
		return caseInsensitive.contains(title);
	}
	
	public void play() throws PlayerException {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Media) {
			Media media = (Media)obj;
			return this.id == media.getID();
		}
		return false;
	}
	
	@Override
	public int compareTo(Media media) {
		if (this.title.compareTo(media.getTitle()) !=0 ) {
			return (this.title.compareTo(media.getTitle()));
		}else {
			return (this.category.compareTo(media.getCategory()));
		}
	}
	
}
