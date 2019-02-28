/* Course Name: CST8284 - Object Oriented Programming (Java)
 Student Name: Forrester Hinds
 Assignment title: Company Management Tool Prototype
 Assignment due date: February 11, 2019
*/

package testCompany;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import company.CompanyConsole;
import company.Employee;
import company.OurDate;

class testEmployee {

	@BeforeAll
	/*
	 * When the test initializes and begins, the system will display...
	 */
	
	public static void setUpBeforeAllTests() {
		
		System.out.println("Starting tests...");
		
	}
	
	@BeforeEach
	/*
	 * Before each test the system will display...
	 */
	
	public void setUpBeforeEachTest() {
		
		System.out.println("Starting test...");
		
	}
	
	/*
	 * After all of the tests, the system will display...
	 */
	
	@AfterAll
	public static void tearDownAfterAllTests() {
		
		System.out.println("Finishing Tests...");
		
	}
	
	/*
	 * After each test, the system will display...
	 */
	
	@AfterEach
	public void tearDownAfterEachTest() {
		
		System.out.println("After test...");

		
	}
	
	/*
	 * testing to see if two employees equal each other in the Employee Array.
	 */
	@Test
	public void testEmployeeEquals() {
		
		Employee e1 = new Employee("Francis Fukuyama", 07, new OurDate(04,9,2014), 48000);
		Employee e2 = new Employee("Francis Fukuyama", 07, new OurDate(04,9,2014), 48000);
		
		assertTrue(e1.equals(e2));
		
	}
	
	/*
	 * Testing to see if employees don't equal each other in the Employee Array.
	 */
	@Test
	public void testEmployeeNotEquals() {
	
	Employee e1 = new Employee("Francis Fukuyama", 07, new OurDate(04,9,2014), 48000);
	Employee e2 = new Employee("Harvey Dent", 34, new OurDate(27,11,1995), 79000);
	Employee e3 = new Employee("Georg Hegel", 703, new OurDate(32,13,1998), 35000);
	
	assertFalse(e1.equals(e2));
	assertFalse(e2.equals(e3));
	
	}
	
	/*
	 * Testing the default OurDate constructor to see if it constructs and saves as a Calendar instance. 
	 * in this case, an instance of the current date based on the system's clock.
	 */
	
	@Test
	public void testDefaultOurDateConstructor() {
	
		
		OurDate d1 = new OurDate();
		Calendar c = Calendar.getInstance();
		
		assertEquals(c.get(Calendar.DATE), d1.getDay());
		assertEquals(c.get(Calendar.MONTH) +1, d1.getMonth());
		assertEquals(c.get(Calendar.YEAR), d1.getYear());
		
	}
	
	/*
	 * testing the OurDate class to see if it stores data and returns the same values when compared against integers.
	 * I used: https://codereview.stackexchange.com/questions/101772/unit-testing-private-constructors-and-getter-setters
	 * to help me understand testing overloaded constructors. 
	 */
	
	@Test
	public void testOverloadedOurDateConstructor() {
		
		OurDate d2 = new OurDate(13, 01, 2013);
		
		assertEquals(13, d2.getDay());
		assertEquals(01, d2.getMonth());
		assertEquals(2013, d2.getYear());
		
	}

}
