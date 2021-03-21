
public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		

		DigitalVideoDisc[] sorted = Cart.sortByCost(new DigitalVideoDisc[] {dvd1,dvd2,dvd3,dvd4,dvd5});
		System.out.println("Sort by cost(decreasing): ");
		System.out.println("**********CART**********");
		for(int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getDetail());
		}
		System.out.println("Total cost:"+ Cart.total(sorted));
		System.out.println("************************");	
		
		
		DigitalVideoDisc[] sorted1 = Cart.sortByTitle(new DigitalVideoDisc[] {dvd1,dvd2,dvd3,dvd4,dvd5});
		System.out.println("Sort by title: ");
		System.out.println("**********CART**********");
		for(int i = 0; i < sorted1.length; i++) {
			System.out.println(sorted1[i].getDetail());
		}
		System.out.println("Total cost:"+ Cart.total(sorted));
		System.out.println("********************");
		
		
		DigitalVideoDisc[] sorted2 = Cart.sortByLength(new DigitalVideoDisc[] {dvd1,dvd2,dvd3,dvd4,dvd5});
		System.out.println("Sort by length(decreasing): ");
		System.out.println("**********CART**********");
		for(int i = 0; i < sorted2.length; i++) {
			System.out.println(sorted2[i].getDetail());
		}
		System.out.println("Total cost:"+ Cart.total(sorted));
		System.out.println("********************");
		
		
		int id = 6;
		DigitalVideoDisc result = Cart.searchById(sorted,id);
		if(result == null) {
			System.out.println("Not Found");
		}else {
			System.out.println(result.getDetail());
		}
		
	}

}
