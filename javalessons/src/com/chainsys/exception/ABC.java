package com.chainsys.exception;

public class ABC {
public static void M1()
public static void M2()
public static void M3()
	{
	try
	{
		m4();
	}
	catch(Exception e)
	{
		System.out.println("Inside Catch"+e.getMessage());
		Throwable t1=e.getCause();
		System.out.println("Cause"+t1.getMessage());
	}	
	}
public static void m4() throws Exception
{
Exception e1=new Exception("Error 1");
//Inner Exception
//e1 is nested inside e2
Exception e2=new Exception("Error 2",e1);
//throw e2;
}
}
