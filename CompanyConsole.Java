/* Course Name: CST8284 - Object Oriented Programming (Java)
 Student Name: Forrester Hinds
 Assignment title: Company Management Tool Prototype
 Assignment due date: February 11, 2019
*/

package company;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class CompanyConsole {

	private static final int addEmployee = 1;
	private static final int displayEmployees = 2;
	private static final int displaySeniorEmployees = 3;
	private static final int exit = 9;
	private Company startUp;
	
	private Scanner input = new Scanner(System.in);
	
	public CompanyConsole() {
		
		startUp = new Company();		
		menu();
		
	}//end of Company Console
	
	public void menu() {
		
		int selection = 0;
		
		do {
			
			System.out.println("**************************************************************************************\n");
			System.out.println("PLEASE MAKE A SELECTION.");
			System.out.println("1. ADD EMPLOYEE\n2. DISPLAY EMPLOYEES\n3. DISPLAY SENIOR EMPLOYEE\n9. EXIT\n");
			System.out.println("**************************************************************************************");		
		
			selection = input.nextInt();
			
			// While loop checking for a correct input and prompting the user for a valid input as necessary.
			
			while (selection != 1 && selection != 2 && selection != 3 && selection != 9) {
				
				System.out.println("ERROR, PLEASE MAKE A SELECTION.");
				System.out.println("1. ADD EMPLOYEE\n2. DISPLAY EMPLOYEES\n3. DISPLAY SENIOR EMPLOYEE\n9. EXIT\n");
				System.out.println("**********************************************************************************");
				
				selection = input.nextInt();
			
			} // end of while loop
			
			if (selection == 1) {
				
				addEmployee(); //calls the addEmployee class
				
			} else if (selection == 2) {
				
				displayEmployee(); //calls the displayEmployee class
				
			} else if (selection == 3) {
				
				displaySeniorEmployee(); //calls the displaySeniorEmployee class
				
			} else {
				
				System.out.println("Goodbye.");
				
			}
	
		
		} while (selection != 9); // if user enters '9', the program exits the menu 'do while' loop.
		
				
		
	}//end of menu
	
	private void addEmployee() {
		
	int day;
	int month;
	int year;
	String name;
	String firstName;
	String lastName;
	int employeeNumber;
	double salary;
	
	System.out.println("SELECTION: 1\nENTER NEW EMPLOYEE INFORMATION:\n\nNAME: ");
	
	/*Information that helped me figure out inputting a name into the Scanner, with spaces, and outputting it without an error from:
	 * https://itaehun.wordpress.com/2010/09/30/flush-in-java-when-using-nextline/ 
	 */
	
	//collecting the full name of the employee on one line without having a space causing an error.
	firstName = input.next();
	lastName = input.next();

	name = firstName + " " + lastName;
	
	System.out.println(name); //for testing
	
	System.out.println("EMPLOYEE NUMBER: ");
	employeeNumber = input.nextInt();
	
	
	/*Trailing code from https://stackoverflow.com/questions/23506429/java-reading-multiple-ints-from-a-single-line
	 * to capture the date at once without separate input prompts. 
	 * Tried:  String conversion[] = input.split(" ");
		       int number[] = Integer.parseInt(conversion);
		       
		But, I found it easier to use a for loop to capture the data reliably. 
	 */
	System.out.println("ENTER THE EMPLOYEE'S START DAY/MONTH/YEAR BY PRESSING ENTER TO SEPERATE INPUTS.");
	int date[] = new int[3];
	for(int i = 0; i < 3; i++)
	{
	    date[i] = input.nextInt();
	}
	
	day = date[0];
	month = date[1];
	year = date[2];
	
	
	
	System.out.println("STARTING SALARY: ");
	salary = input.nextDouble();
	
	startUp.addEmployee(name, employeeNumber, new OurDate(day, month, year), salary);
	
	
	}//end of add employee
	
	private void displayEmployee() {
		
		/* snippet of code, String Format, to cleanup spacing in printing the column headers from:
		 * https://stackoverflow.com/questions/5249566/adding-whitespace-in-java - didn't work, but \t was suggested as well.
		 */
		System.out.println();
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("   NAME\t\t EMPLOYEE NUMBER\t    START DATE\t\t  SALARY");
	
		for(int j = 0; j < startUp.currentNumberEmployees(); j++) {
			
			System.out.println(startUp.getEmployees()[j]);

		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
		
		
	}//end of displayEmployee
	
	private void displaySeniorEmployee() {
		
		System.out.println();
		System.out.println();
		System.out.println("SENIOR EMPLOYEE");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("   NAME\t\t EMPLOYEE NUMBER\t    START DATE\t\t  SALARY");
		
		System.out.println(startUp.findSeniorEmployee());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
		
	}//end of displaySeniorEmployee
	
	public static void main(String [] args) {
		
		CompanyConsole CC = new CompanyConsole();
		
		
	}//end of main
}
