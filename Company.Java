/* Course Name: CST8284 - Object Oriented Programming (Java)
 Student Name: Forrester Hinds
 Assignment title: Company Management Tool Prototype
 Assignment due date: February 11, 2019
*/

package company;

import java.util.Calendar;

public class Company {

	private Employee[] employees;
	private int numberEmployees;
	private static final int maximumEmployees = 10;
	
	/*
	 * Constructor class for the Company abstraction.
	 */
	
	public Company() {
		
		numberEmployees = 0;
		employees = new Employee[maximumEmployees];
		
	}//end of company constructor class
	
	/*
	 * constructor class for when the user makes a request to add employees. 
	 */
	
	public void addEmployee(String name, int employeeNumber, OurDate startDate, double salary) {
		
		if (isMaximumEmployees() != true) {
			
			Employee newEmployee = new Employee(name, employeeNumber, startDate, salary);
			employees[numberEmployees] = newEmployee;
			numberEmployees++;
			
		} else {
			
			System.out.println("ERROR, MAXIMUM NUMBER OF EMPLOYEES (10) ACHIEVED.");
			
		}
		
	}//end of addEmployee
	
	/*
	 * method that returns the current number of employees for use in the employees array and when creating a new employee.
	 */
	
	public int currentNumberEmployees() {
		
		return numberEmployees;
		
	}//end of currentNumberEmployees
	
	/*
	 * Method that returns true or false depending on if the maximum number of employees have been added to the database.
	 */
	
	public boolean isMaximumEmployees() {
		
		if (numberEmployees == maximumEmployees) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}//end of isMaximumEmployees
	
	/*
	 * Array that returns the employees array when called upon.
	 */
	
	public Employee[] getEmployees() {
		
		return employees;
		
	}//end of getEmployees
	
	/*
	 * method that returns the most senior employee in the organization based on comparing the entire employees array.
	 */
	
	public Employee findSeniorEmployee() {
		
		Employee seniorEmployee = new Employee();

		/* As the most senior employee would have the oldest date, I set the minimum date and am comparing it to 
		 * each instance in the employees array. Source that helped me figure out the code: https://stackoverflow.com/questions/20465783/sort-an-array-of-dates-based-on-the-current-date
		 * and https://www.tutorialspoint.com/java/util/java_util_calendar.htm
		 */
		
		Calendar minDate = Calendar.getInstance();
		Calendar dates = Calendar.getInstance();

		
		minDate.set(seniorEmployee.getStartDate().getDay(), seniorEmployee.getStartDate().getMonth(), seniorEmployee.getStartDate().getYear());
		
		for(int i = 0; i < numberEmployees; i++) {
			
			dates.set(employees[i].getStartDate().getDay(), employees[i].getStartDate().getMonth(), employees[i].getStartDate().getYear());
			if(dates.before(minDate)) {
				
				seniorEmployee = employees[i];
				minDate.set(seniorEmployee.getStartDate().getDay(), seniorEmployee.getStartDate().getMonth(), seniorEmployee.getStartDate().getYear());
				
			}
		}
		
		return seniorEmployee;
		
	}//end of findSeniorEmployees
	
	
}
