package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.PlayerExecption;

public class DigitalVideoDise extends Disc implements Playable, Comparable<Object>{	
	public DigitalVideoDise() {
		super();
	}
	
	public DigitalVideoDise(String id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost, director, length);
	}
	
	public DigitalVideoDise(String title) {
		super();
		this.title = title;
	}
	
	public void play() throws PlayerExecption {
		if ( this.getLength() > 0 ) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
		else {
			throw new PlayerExecption("ERROR: DVD length is non-positive!");
		}
	}

	public boolean search(String title) {
		boolean search = true;
		
		if (this.getTitle().contains(title)) {
			return search;
		} 
		else {
			String parts[] = title.split(" ");	
			for (String part: parts) {
				if ( !(this.getTitle().contains(part))) {
					search = false;
					break;
				}
			}
		}
		return search;
	}
	
	@Override
	public int compareTo(Object obj) {
		if ( obj instanceof DigitalVideoDise ) {
			float objCost = ((DigitalVideoDise) obj).getCost();
			if ( cost >objCost ) {
				return 1;
			}
			else if ( cost == objCost ) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			System.out.println("Check again");
			return -2;
		}	
	}
}
