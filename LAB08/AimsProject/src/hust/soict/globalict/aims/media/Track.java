package hust.soict.globalict.aims.media;

public class Track implements Playable  {

	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Track) {
			Track track = (Track)obj;
			if(this.length == track.getLength() && this.title.compareTo(track.getTitle()) == 0 ) {
				return true;
			}
		}
		return false;
	}
}
