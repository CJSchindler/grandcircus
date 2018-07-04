package practice2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Practice2 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in); // sets up scanner for user input
		//DateTimeFormatter f = DateTimeFormatter.parse( "dd/mm/yyyy" );
		
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy"); //formats input to readable format
		
		System.out.println("Enter a start date in the format M/D/YYYY, with no leading zeroes:"); //request date from the user
		String userDate1 = scnr.nextLine(); //reads the user input as a string
		LocalDate date1 = LocalDate.parse(userDate1, dateFormat);
		
		System.out.println("Enter an end date in the format M/D/YYYY, with no leading zeroes:"); //request another date from the user
		String userDate2 = scnr.nextLine(); //reads the user input as a string
		LocalDate date2 = LocalDate.parse(userDate2, dateFormat);
		
		Period p = Period.between(date1, date2); //calculate difference between dates
		 
		System.out.printf("Difference is %d years, %d months and %d days",
		                    p.getYears(), p.getMonths(), p.getDays());
	
	}
}
