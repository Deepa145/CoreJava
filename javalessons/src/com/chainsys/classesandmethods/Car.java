/**
 * 
 */
package com.chainsys.classesandmethods;

/**
 * @author deep3108
 *
 */

	/**
	 * @param args
	 */
public class Car {

       private final String regNo;
       private int yearOfPurchase;
       private String color;
       private String fuel;
       
       public Car (String rno)
       {
    	   this.regNo=rno;
       }

	public int getYearOfPurchase() {
		return yearOfPurchase;
	}

	public void setYearOfPurchase(int yearOfPurchase) {
		this.yearOfPurchase = yearOfPurchase;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getRegNo() {
		return regNo;
	}
	

}
