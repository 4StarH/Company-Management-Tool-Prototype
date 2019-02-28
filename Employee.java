/* Course Name: CST8284 - Object Oriented Programming (Java)
 Student Name: Forrester Hinds
 Assignment title: Company Management Tool Prototype
 Assignment due date: February 11, 2019
*/


package company;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class Employee {

	private String name;
	private int employeeNumber;
	private OurDate startDate;
	private double salary;
	DecimalFormat pay = new DecimalFormat("###,###,##0.00");
	SimpleDateFormat hired = new SimpleDateFormat("dd/MM/yyyy");
	
	
	/*NumberFormat to set a minimum number of digits displayed for the Employee Number inspired by:
	 * https://stackoverflow.com/questions/12421444/how-to-format-a-number-0-9-to-display-with-2-digits-its-not-a-date
	 */
	
	NumberFormat empnum = new DecimalFormat("0000");
	
	/*
	 * setting the default values for employee. insight into doing this from lecture, Caroline MacIssac (2019)
	 */
	
	public Employee() {
		
		this("unknown", -9, new OurDate(), -1);
		
	} //end of Employee
	
	/*
	 * Employee constructor class. 
	 */
	
	public Employee(String name, int employeeNumber, OurDate startDate, double salary) {
		
		this.name = name;
		this.employeeNumber = employeeNumber;
		this.startDate = startDate;
		this.salary = salary;
		
		
	}//end of employee constructor class
	
	/*
	 * retrieves the employee name.
	 */

	public String getName() {
		
		return name;
		
	}
	
	/*
	 * sets the name saved in an Employee instance based on user input.
	 */
	
	private void setName(String name) {
		
		this.name = name;
		
	}
	
	/*
	 * retrieves the employee number.
	 */
	
	public int getEmployeeNumber() {
		
		return employeeNumber;
		
	}
	/*
	 * sets the employee number saved in an Employee instance based on user input.
	 */
	
	private void setEmployeeNumber(int employeeNumber) {
		
		this.employeeNumber = employeeNumber;
		
	}
	
	/*
	 * retrieves the start date.
	 */
	
	public OurDate getStartDate() {
		
		return startDate;
		
	}
	
	/*
	 * sets a start date saved in an Employee instance based on user input.
	 */
	
	private void setStartDate(OurDate startDate) {
		
		this.startDate = startDate;
		
	}
	
	/*
	 * Retrieves the salary variable.
	 */
	
	public double getSalary() {
		
		return salary;
		
	}
	
	/*
	 * sets the salary in an Employee instance based on user input.
	 */
	
	private void setSalary(double salary) {
		
		this.salary = salary;
		
	}
	
	/*
	 * returns the employee class as name [tab][tab] employee number [tab][tab][spaces] Start Date [tab][tab] $salary.
	 */
	
	@Override
	public String toString() {
		
		/* String Formatting to clean up and make a more anesthetically pleasing output understood from:
		 * https://www.novixys.com/blog/java-string-format-examples/
		 */
		
		return name + "\t\t" + empnum.format(employeeNumber) + "\t\t    " + startDate + "\t\t" + "$" + pay.format(salary);
	}

	/*
	 * makes sure that objects that are the same return as the same object.
	 */

	@Override
	public boolean equals(Object obj) {
		
		Employee e1 = (Employee) obj;
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		if (employeeNumber != e1.employeeNumber)
			return false;
		
		if (name == null) {
			if (e1.name != null)
				return false;
			
		} else if (!name.equals(e1.name))
			return false;
		
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(e1.salary))
			return false;
		
		if (startDate == null) {
			
			if (e1.startDate != null)
				return false;
			
		} else if (!startDate.equals(e1.startDate))
			return false;
		
		return true;
	}
	
	
	
}
