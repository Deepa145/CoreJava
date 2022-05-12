package edu.lessons.day60.oops.interfaces;
public  class Calculator implements ICalculator {

public int v1;
public int v2;

public int add(int v1, int v2) 
{
    System.out.println( v1  + v2);
    return v1 + v2;
}
public int multiply(int v1,int v2)
{
	System.out.println( v1  * v2);
    return v1 * v2;

}

public int divide(int v1, int v2) {
    System.out.println( v1 / v2);
    return v1 / v2;
}
}
