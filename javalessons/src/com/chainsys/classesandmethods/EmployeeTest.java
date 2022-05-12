/**
 * 
 */
package com.chainsys.classesandmethods;

/**
 * @author deep3108
 *
 */
public class EmployeeTest {
	public static void testEmployee()
	{
	Employee firstEmployee=new Employee(1234);
	firstEmployee.setName("Deepa");
	System.out.println(firstEmployee.getName());
	}
	public static void testCity()
	{
		Employee firstEmployee=new Employee(1234);
		firstEmployee.setCity("Chennai");
		System.out.println(firstEmployee.getCity());
		
	}
}