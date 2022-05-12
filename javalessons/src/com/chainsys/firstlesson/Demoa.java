package com.chainsys.firstlesson;
	public class Demoa
{
public static int DataA;//static global variable
public final int DataB;
public final static int DAtaC=300;
//public final int dataD;
//constant
//constructor
/*
 * constructor is a special method
 * The name of the constructor and the name of the class will be same
 * constructor don't have return type
 * constructor can take parameter
 */
public Demoa(int dataB)
{
	/*Assigning value to the global read only field(this.DataB)*/
   this.DataB=dataB;	
}
/**
 * static method can be called without an object.
 */
 public static void sayHello()
{
  System.out.println("Hii guys!!!");	
}
public void greetUser()
  {
    System.out.println("Greetings User!!!");	
 }
}

