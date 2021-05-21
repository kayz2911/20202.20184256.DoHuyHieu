package hust.soict.globalict.aims.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class DateUtils {
	public static int compareDates ( String dateString1, String dateString2) throws Exception {
		MyDate date1 = new MyDate(dateString1);
		MyDate date2 = new MyDate(dateString2);
		
		Date firstDate = date1.stringToDate();
		Date secondDate = date2.stringToDate();
		
		int result = firstDate.compareTo(secondDate);
		return result;
	}
	
	public static void sortDates( int n, String ... dateStrings) throws Exception {
		Date dates[] = new Date[n];
		for ( int i = 0; i < n; i++ ) {
			MyDate dateObject = new MyDate(dateStrings[i]);
			dates[i] = dateObject.stringToDate();
		}
		Arrays.sort(dates);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Order after sorting is:");
		for ( Date date: dates ) {
			System.out.println(format.format(date));
		}
	}
}

