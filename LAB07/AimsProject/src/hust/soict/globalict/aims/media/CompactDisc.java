package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}


	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost,List<Track> tracks) {
		super(title,category,director,length,cost);
		this.tracks = tracks;
	}
	
	public CompactDisc(String title, String category, String director, float cost) {
		super(title,category,director,cost);	
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	
	
	
	public void addTrack(Track tr){
		int flag = 0;
		for(Track track : this.tracks) {
			if(track.equals(tr)) {
				System.out.println("The author has been exist");
				flag = 1;
			}
		}
		if(flag == 0) {
			this.tracks.add(tr);
		}
	}
	
	public void removeTrack(Track tr){
		int flag = 0;
		for(Track track : this.tracks) {
			if(!track.equals(tr)) {
				System.out.println("The author has not been exist");
				flag = 1;
			}
		}
		if(flag == 0) {
			this.tracks.remove(tr);
		}
	}
	
	public int getLength() {
		int sum = 0;
		for(Track track : this.tracks) {
			sum += track.getLength();
		}
		return sum;
	}
	
	public void play() {
		super.play();
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("Category CD: " + this.getCategory());
		System.out.println("Cost CD: " + this.getCost());
		System.out.println("Number of tracks in CD: " + this.tracks.size());
		for(Track track : this.tracks) {
			track.play();
		}
	} 
	
	public String getDetail() {
		return id + ".CD " + title + " - " + category  + "- " + cost +" $";
	}

}
