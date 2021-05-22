package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.exception.PlayerException;

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
	
	public CompactDisc(String title, String category, String director, int length, float cost, String artist, ArrayList<Track> tracks) {
		super(title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;	
	}
	
	public CompactDisc(String title, String category, String director, float cost) {
		super(title,category,director,cost);	
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	
	public void addTrack(ArrayList<Track> track1) {
		for(int i = 0;i<track1.size();i++) {
			tracks.add(track1.get(i));
		}
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
	
	
	
	public void play() throws PlayerException {
		if ( this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("Category CD: " + this.getCategory());
			System.out.println("Cost CD: " + this.getCost());
			System.out.println("Length CD:" + this.getLength());
			java.util.Iterator iterator = tracks.iterator();
			Track nexTrack;
			while ( iterator.hasNext() ) {
				nexTrack = (Track) iterator.next();
				try {
					nexTrack.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	} 
	
	@Override
	public String toString() {
		return id + ".CD "  + " " + title + " - " + category + " - "  + cost +" $";
	}
	

}
