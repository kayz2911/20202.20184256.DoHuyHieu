package hust.soict.globalict.aims.media;

public class CompactDisc extends Disc {

	public CompactDisc(String title, String category, String director, int length, float cost,int id) {
		super(title,category,director,length,cost,id);
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
	}
	
	public CompactDisc(String title, String category, String director, float cost) {
		super(title,category,director,cost);	
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title,category,cost);
	}

}
