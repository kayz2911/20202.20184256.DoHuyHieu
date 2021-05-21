package hust.soict.globalict.test.disc;
import hust.soict.globalict.aims.media.DigitalVideoDise;

public class TestPassingParameter {
	
	public static void swap( DigitalVideoDise dvd1, DigitalVideoDise dvd2) {
		DigitalVideoDise tmp = new DigitalVideoDise(dvd1.getTitle(), dvd1.getCategory(), dvd1.getDirector(), dvd1.getLength(), dvd1.getCost() );
		dvd1.ChangeDVD(dvd2);
		dvd2.ChangeDVD(tmp);
	}

	public static void main(String[] args) {
		DigitalVideoDise jungleDVD = new DigitalVideoDise("Jungle");
		DigitalVideoDise cinderellaDVD = new DigitalVideoDise("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle() );
		
	}

}
