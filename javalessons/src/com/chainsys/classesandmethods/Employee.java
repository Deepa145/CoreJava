/**
 * 
 */
package com.chainsys.classesandmethods;

/**
 * @author deep3108
 *
 */
public class Employee {

	/**
	 * @param args
	 */
	private final int empID;
	private String name;
	private String city;
	private long salary;
	public Employee(int id)
	{
		this.empID=id;
	}
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public int getEmpID()
	{
		return empID;
	}
	public String getCity()
	{
	return city;	
	}
	public void setCity(String city)
	{
	this.city=city;	
	}
	public long getSalary()
	{
	return salary;	
	}
	public void setSalary(long salary)
	{
	this.salary=salary;	
	}
	}