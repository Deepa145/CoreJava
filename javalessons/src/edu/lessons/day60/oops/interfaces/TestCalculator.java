package edu.lessons.day60.oops.interfaces;

public class TestCalculator {


	   public static void main(String[] args) {
	     Calculator cal = new Calculator();

	     cal.add(5, 4);
	     cal.multiply(3, 2);
         cal.divide(6,2);
	     
	   }
	
public static void testA()
{
public static void testMaker()
{
Calculator firstCalculator=new Calculator();
if(firstCalculator instanceof ICalculator)
{
	ICalculator contract=firstCalculator;
	int output=0;
	output=contract.add(10,5);
	System.out.println(output);
	output=contract.multiply(10,5);
	System.out.println(output);
	output=contract.divide(10,5);
	System.out.println(output);
}
else
	System.out.println(firstCalculator.getClass().getName()+"does not Implement ICalculator");
}
}