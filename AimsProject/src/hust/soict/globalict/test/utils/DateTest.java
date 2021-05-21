package hust.soict.globalict.test.utils;
import java.util.*;

import com.sun.net.httpserver.Authenticator.Result;

import hust.soict.globalict.aims.utils.DateUtils;
import hust.soict.globalict.aims.utils.MyDate;
public class DateTest {

	public static void main(String[] args) throws Exception {
		MyDate myDate = new MyDate();
		Scanner keyboard = new Scanner(System.in);
		
		String date, date1, date2, date3;
		System.out.println("Enter your date: ");
		date = keyboard.nextLine();
		
		int accept = myDate.accept(date);
		if ( accept == 1) {
			System.out.println("Date is valid");
			int option = myDate.chooseMethod();
			date = myDate.print(option);
			System.out.println("Your date is: " + date);
		}
		else {
			System.out.println("Date is invalid");
		}
		
		System.out.println("Please enter 2 dates to compare: ");
		System.out.println("The first date: ");
		date1 = keyboard.nextLine();
		System.out.println("The second date: ");
		date2 = keyboard.nextLine();
		
		DateUtils dateUtils = new DateUtils();
		int compare = dateUtils.compareDates(date1, date2);
		
		if ( compare == 0) {
			System.out.println("Two dates are equal");
		} else if (compare < 0) {
			System.out.println("date 1 is before date 2");
		} else {
			System.out.println("date 1 is after date 2");
		}
		
		System.out.println("Enter another date:");
		date3 = keyboard.nextLine();
		dateUtils.sortDates(3, date1, date2, date3);
	}
}
