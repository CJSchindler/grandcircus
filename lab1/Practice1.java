package practice1;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in); // sets up scanner for user input
		int userNum1 = 0; // this will be the first integer the user inputs
		int userNum2 = 0; // this is the second integer the user inputs
		boolean isNotSameLength; //indicates whether the integers are same length or not
		int userNum1Length; //this is the length of the integer
		int i; //variable for iterations of the loop
		int sum1; //variable for the sum of two digits
		
		do {
			System.out.print("Enter an integer: "); // requests input from user
			userNum1 = scnr.nextInt(); // assigns user input value to userNum1
			
			System.out.print("Enter an integer with the same number of digits as the first integer: ");
			userNum2 = scnr.nextInt(); // assigns user input value to userNum2
			
			//compares length of integers, finds the difference to determine if they are the same length
			isNotSameLength = (Integer.toString(userNum1).length() - Integer.toString(userNum2).length() != 0);
			
			if (isNotSameLength) { //if integers are not the same length, asks user to try again
				System.out.println("Integers are not the same length. Please try again.");
			}
					
		} while (isNotSameLength); //if integers are the same length, move to the next step
	
		userNum1Length = Integer.toString(userNum1).length(); //get the length of the userNum1
		
		int placeHolder = -1; // Magic Number to indicate first iteration of the loop
		boolean status = true; //this indicates if the digits add up to the same number or not
		
		for (i = userNum1Length; i > 0; i = i-1 ) { //repeats the loop for every digit in the integer
		
			//gets the sum of the leftmost digits of both integers
			sum1 = (int) (userNum1 / (Math.pow(10, (i - 1)))) + (int) (userNum2 / (Math.pow(10, (i - 1)))); 
			
			/*if the sum is not equal to the place holder and it's not the first iterationof this loop, then the status is
			 * false and break out of the loop */
			if ((sum1 != placeHolder) && (placeHolder != -1) ) { 
				status = false;
				break;
			}
			
			userNum1 = (int) (userNum1 % (Math.pow(10, (i - 1)))); //update userNum1 removing leftmost digit
			userNum2 = (int) (userNum2 % (Math.pow(10, (i - 1)))); //update userNum2 removing leftmost digit
			
			placeHolder = sum1; //update placeHolder to remember the sum of the digits in the first iteration of the loop
			
		}
		System.out.println(status); //print the status, i.e. if the digits add up to the same number or not
	}	
}

