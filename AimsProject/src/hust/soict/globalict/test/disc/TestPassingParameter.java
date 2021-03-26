package hust.soict.globalict.test.disc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		wrapper wo1 = new wrapper(jungleDVD);
		wrapper wo2 = new wrapper(cinderellaDVD);
		swap(wo1, wo2);
		System.out.println("jungle DVD title: " + wo1.a.getTitle());
		System.out.println("cinderella DVD title: " + wo2.a.getTitle());
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle DVD title: "+ jungleDVD.getTitle());
	}
	
	public static void swap(wrapper o1, wrapper o2) {
		DigitalVideoDisc tmp = o1.a;
		o1.a = o2.a;
		o2.a = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd,String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);	
	}

}

class wrapper {
	DigitalVideoDisc a;
	wrapper (DigitalVideoDisc a){this.a = a;}
}

