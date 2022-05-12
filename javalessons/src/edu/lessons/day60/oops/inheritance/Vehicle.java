package edu.lessons.day60.oops.inheritance;
public class Vehicle
{
  public String Regno;
  
  public Vehicle(String x)   
  {
  	  System.out.println("Vehicle Constructed "+this.hashCode());
  }
  
  public void move()   
  {
	  System.out.println("Vehicle.move");
  }
 }