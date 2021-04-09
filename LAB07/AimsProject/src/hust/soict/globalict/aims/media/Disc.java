package hust.soict.globalict.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(String title, String category,String director, int length, float cost, int id ) {
		super(title,category,cost);
		this.length = length;
		this.director = director;
		this.id = id;
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
		super(title,category,cost);
		this.director = director;
		this.length = length;
	}
	
	public Disc(String title, String category, String director, float cost) {
		super(title,category,cost);
		this.director = director;	
	}
	
	public Disc(String title, String category, float cost) {
		super(title,category,cost);
	}

}
