package hust.soict.globalict.aims.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class MyDate {
	private int day;
	private int month;
	private int year;
	public static String[] monString = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "Octorber", "November", "December"};
	public static String[] monLetters = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public MyDate() {
	}
	
	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public MyDate(String day,String month, String year) {
		super();
		this.day = Integer.parseInt(day);
		this.month = Integer.parseInt(month);
		this.year = Integer.parseInt(year);
	}
	
	public MyDate(String dateString) {
		String part[] = dateString.split(" ");
		int ok = accept(dateString);
		if ( ok == 1 ) {
			System.out.println("Your date is: " + dateString);
		} else {
			System.out.println("Your date is invalid!");
		}
	}
	
	private int convertMonth (String s) {
		int imonth = -1;
		switch ( s ) {
		case "January":
			imonth = 1;
			break;
		case "February":
			imonth = 2;
			break;
		case "March":
			imonth = 3;
			break;
		case "April":
			imonth = 4;
			break;
		case "May":
			imonth = 5;
			break;
		case "June":
			imonth = 6;
			break;
		case "July":
			imonth = 7;
			break;
		case "August":
			imonth = 8;
			break;
		case "September":
			imonth = 9;
			break;
		case "Octorber":
			imonth = 10;
			break;
		case "November":
			imonth = 11;
			break;
		case "December":
			imonth = 12;
			break;
		default:
			break;
		}
		
		return imonth;
	}
	
	private int convertDay( String s) {
		int index = s.indexOf("th");
		String myDay = null;
		if ( index != -1) {
			myDay = s.substring(0, index);
		} else if ( (index = s.indexOf("st")) !=-1) {
			myDay = s.substring(0, index);
		} else if ( (index = s.indexOf("nd")) !=-1) {
			myDay = s.substring(0, index);
		} else if ( (index = s.indexOf("rd")) !=-1) {
			myDay = s.substring(0, index);
		}
		
		int day = Integer.parseInt(myDay);
		return day;
	}
	
	
	public int accept( String date) {
		int ok = 0;
		String part[] = date.split(" ");
		
		this.month = convertMonth( part[0]);
		if ( this.month == -1 ) {
			return ok;
		}
		else {
			this.day = convertDay( part[1]);
			this.year = Integer.parseInt( part[2]);
		
			switch ( this.month ) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8: 
			case 10:
			case 12:
				{
					if ( this.day >=0 && this.day <= 31 && this.year >= 0) {
						ok = 1;
					}
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				{
					if ( this.day >=0 && this.day <= 30 && this.year >= 0) {
						ok = 1;
					}
				}
				break;
			case 2:
				if ( ( this.year % 4 == 0 ) || ( year % 100 == 0 && year % 400 != 0) ) {
					if ( this.day >= 0 && this.day <= 29 ) {
						ok = 1;
					}
				}
				else {
					if ( this.day >= 0 && this.day <= 28 )
						ok = 1;
				}
				break;
			default:
				break;
			}
		}
		return ok;
	}
	
	public void print() {
		String stringMonth = monString[month- 1];
		String dateString = stringMonth + " " + Integer.toString(day) + "th " + Integer.toString(year);
		System.out.println("Your date is " + dateString);
		
		
	}
	public int chooseMethod() {
		int option = 0;
		Scanner keyBoard = new Scanner(System.in);
		do {
			System.out.println("1: yyyy-MM-dd. Example: 1930-02-03");
			System.out.println("2: d/M/yyyy. Example: 3/2/1930");
			System.out.println("3:MMM d yyyyy. Example Feb 3 1930");
			System.out.println("4: mm-dd-yyyy. Example: 02-03-1930");
			System.out.println("Pleasr choose your format:");
			
			option = keyBoard.nextInt();
			if ( option == 0) {
				System.out.println("Your option is invalid. Choose again");
			}
		}while( option == 0 );
		return option;
	}
	public String print( int option) {
		String dateString = null;
		
		switch (option) {
		case 1:
			dateString = Integer.toString(year) +"-"+ String.format("%02d", month)+ "-" + String.format("%02d", day);
			break;
		case 2:
			dateString = Integer.toString(day) +"/" + Integer.toString(month) + "/" + Integer.toString(year);
			break;
		case 3:
			dateString = monLetters[month - 1] +" " + Integer.toString(day) + " " +Integer.toString(year);
			break;
		case 4:
			dateString = String.format("%02d", month) + "-" + String.format("%02d", day) + "-" + Integer.toString(year);
		default:
			break;
		}
		return dateString;
	}
	
	public Date stringToDate()throws Exception {
		String dateString = print(1);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		return date;		
	}
	
}
 

