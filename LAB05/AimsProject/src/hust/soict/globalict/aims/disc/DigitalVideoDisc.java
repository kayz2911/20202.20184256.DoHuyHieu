package hust.soict.globalict.aims.disc;
import java.time.LocalDate;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate dateAdded;
	private static int nbDigitalVideoDisc = 0;
	private int id ;
	
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
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getID() {
		return id;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDisc ++;
		this.id = nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDisc ++;
		this.id = nbDigitalVideoDisc;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = id;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}

	public String getDetail() {
		return id + ".DVD " + title + " - " + category + " - "  + director + " - " + length + ": " + cost +" $";
	}
	
	public boolean search(String title) {
		String caseInsensitive = this.title.toLowerCase();
		title = title.toLowerCase();
		return caseInsensitive.contains(title);
	}
	
}
