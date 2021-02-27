import java.util.Scanner;
public class Ex4{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input month: ");
		String month = scanner.nextLine();
		int s = 0;
		int days = 0;
		while( s == 0 ) {
			if(month.equals("January") == true || month.equals("Jan.") == true || month.equals("Jan") == true || month.equals("1") == true)  {
				s = 1;
				days = 31;
			}
			else if(month.equals("February") == true || month.equals( "Feb.") == true || month.equals("Feb") == true || month.equals("2") == true) {
				s = 2;
				days = 28;
			}
			else if(month.equals("March") == true || month.equals("Mar.") == true || month.equals("Mar") == true || month.equals("3") ==true) {
				s = 3;
				days = 31;
			}
			else if(month.equals("April") == true || month.equals("Apr.") == true || month.equals("Apr") == true || month.equals("4") == true) {
				s = 4;
				days = 30;
			}
			else if(month.equals("May") == true || month.equals("May") == true || month.equals("May") == true || month.equals("5") == true) {
				s = 5;
				days = 31;
			}
			else if(month.equals("June") == true || month.equals("June") == true || month.equals("Jun") == true || month.equals("6") == true) {
				s = 6;
				days = 30;
			}
			else if(month.equals("July") || month.equals("July") || month.equals("Jul") || month.equals("7") == true) {
				s = 7;
				days = 31;
			}
			else if(month.equals("August") == true || month.equals("Aug.") == true || month.equals("Aug") == true || month.equals("8") == true) {
				s = 8;
				days = 31;
			}
			else if(month.equals("September") == true || month.equals("Sep.") == true || month.equals("Sep") == true || month.equals("9") == true) {
				s = 9;
				days = 30;
			}
			else if(month.equals("October") == true || month.equals("Oct.") == true || month.equals("Oct") == true || month.equals("10") == true) {
				s = 10;
				days = 31;
			}
			else if(month.equals("November") == true || month.equals("Nov.") == true || month.equals("Nov") == true || month.equals("11") == true) {
				s = 11;
				days = 30;
			}
			else if(month.equals("December") == true || month.equals("Dec.") == true || month.equals("Dec") == true || month.equals("12") == true) {
				s = 12;
				days = 31;
			}
			else {
				System.out.println("Invalid month!");
				month = scanner.nextLine();
			}
		}
	}
}
