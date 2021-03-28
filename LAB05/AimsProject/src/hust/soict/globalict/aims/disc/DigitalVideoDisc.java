package hust.soict.globalict.aims.disc;
import java.time.*;
public class DigitalVideoDisc {
	public DigitalVideoDisc(String title, String category, String director, int length, float cost,int id) {
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
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
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
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	//If you create a constructor method to build a DVD by title then create a constructor method to 
	//build a DVD by category, JAVA does not allow to do it because of duplication
	
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate DateAdd;
	private static int nbDigitalVideoDisc = 0;
	private int id;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	public int getId() {
		return id;
	}
	
	public String setTitle(String title){
		return title;
	}
	
	public String getDetail() {
		return "ID:" + id + "-"+ "DVD-" + title + "-" + category + "-"+ director + "-"+ length + "-"+ cost + "$"; 
	}
	
	public boolean search(String title) {
		String caseInsensitive = this.title.toLowerCase();
		title = title.toLowerCase();
		return caseInsensitive.contains(title); 
	}
	
}
