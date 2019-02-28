/* Course Name: CST8284 - Object Oriented Programming (Java)
 Student Name: Forrester Hinds
 Assignment title: Company Management Tool Prototype
 Assignment due date: February 11, 2019
 */

package company;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;



public class OurDate {

	
	private static final Calendar CAL = Calendar.getInstance();
	//grabbing the date from the computer's processor using the Calendar utility.
	
	private int day;
	private int month;
	private int year;
	NumberFormat formatDate = new DecimalFormat("00");
	NumberFormat formatYear = new DecimalFormat("0000");
	
	/*
	 * Constructor class for our date that draws the current day, month, and year from the system.
	 */
	
	public OurDate() {
		
		this.day = CAL.get(Calendar.DATE);
		this.month = CAL.get(Calendar.MONTH) + 1;
		this.year = CAL.get(Calendar.YEAR);
				
			
		
	}//end of OurDate Constructor
	
	/*
	 * OurDate copy that saves the date dependent on user input. 
	 */

	public OurDate(int day, int month, int year) {
		
		this.day = day;
		this.month = month;
		this.year = year;
		int year2;
		int day2;
		int month2;
		year2 = this.year;
		day2 = this.day;
		month2 = this.month;
		
		//using if statements to ensure the accuracy of inputs.
		
		
		
		//making sure the values entered for month are valid.
		if (month2 <= 0) {
			
			this.month = 1;
			
		} else if (month2 > 12) {
			
			this.month = 12;
			
		}
		
		
		//checking to make sure values entered in the day slot are valid.
		if (day2 > 28 && month2 == 2) {
			
			this.day = 28;
			
		} else if ((day2 > 30 && month2 == 9) || (day2 >30 && month2 == 4) || (day2 > 30 && month2 == 6) || (day2 > 30 && month2 == 11)) {
			
			this.day = 30;
			
		}
		
		
		//ensuring values entered in the year slot are valid
		
		if (year2 <= 19) { //if the year entered is less than the current year's last two digits
			
			this.year = this.year + 2000;
			
		} else if (year2 > 2019) { // if the year entered is greater than the current year, assume the year is meant to be 19##
			
			this.year = (this.year - 2000) + 1900;
			
		} else if (year2 > 19 && year2 < 100) { //if the year is greater than the last to digits of the current year but less than 99
			
			this.year = this.year + 1900;
			
		} else if (year2 >= 100 && year2 < 1000) {
			
			this.year = this.year + 1000;
			
		}
		
		if (year2 < 1900) {
			
			this.year = CAL.get(Calendar.YEAR);
			
		} 
		
		
	}//end of OurDate Copy Class
	
	/*
	 * returns the day inputed by the user.
	 */
	
	public int getDay() {
		
		return day;
		
	}//end of getDay
	
	/*
	 * sets the day saved in an OurDate instance based on the date inputed by the user.
	 */
	
	private void setDay(int day) {
		
		this.day = day;
		
	}//end of setDay void
	
	/*
	 * Retrieves the month.
	 */
	
	public int getMonth() {
		
		return month;
		
	} //end of getMonth
	
	/*
	 * sets the month saved in an OurDate instance to the month inputed by the user.
	 */
	
	private void setMonth(int month) {
		
		this.month = month;
		
	} //end of setMonth void
	
	/*
	 * retrieves the year.
	 */
	
	public int getYear() {
		
		return year;
		
	}//end of getYear
	
	/*
	 * sets the year in an OurDate instance to the user's input.
	 */
	
	private void setYear(int year) {
		
		this.year = year;
		
	}//end of getYear void
	
	
	
	/*
	 * returns the date as DD/MM/YYYY
	 */
	@Override
	public String toString() {
		return formatDate.format(day) + "/" + formatDate.format(month) + "/" + formatYear.format(year);
	}

	/*
	 * makes sure that objects that are the same return as the same object.
	 */
	
	@Override
	public boolean equals(Object obj) {
		
		OurDate d1 = (OurDate) obj;
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		if (day != d1.day)
			return false;
		
		if (month != d1.month)
			return false;
		
		if (year != d1.year)
			return false;
		
		return true;
	}

}//end of OurDate Class
