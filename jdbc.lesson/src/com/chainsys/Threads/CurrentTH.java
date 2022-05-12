package com.chainsys.Threads;

public class CurrentTH {
	public static void main(String args[])
	{
	 try{
		 Thread t1=Thread.currentThread();
		 System.out.println("Th ID: " +t1.getId() );
		 System.out.println("Th State: " +t1.getState() );
		 System.out.println("Th Priority: " +t1.getPriority());
		 System.out.println("Th ISAlive: " +t1.isAlive());
		 System.out.println("Th Max Priority: " +Thread.MAX_PRIORITY);//10
		 System.out.println("Th Min priority: " +Thread.MIN_PRIORITY);//1    the maximum priority value is run first.
	 }
catch(Exception e)
	 {
		 System.out.println(e.getMessage());
	 }
	}
}

