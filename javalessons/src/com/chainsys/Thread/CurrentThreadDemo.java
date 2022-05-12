package com.chainsys.Thread;

public class CurrentThreadDemo {

	public static void main(String[] args) {
		
			// TODO Auto-generated method stub
try
{
	Thread t1=Thread.currentThread();
	System.out.println("MainThread ID:" + t1.getId());
	Worker w=new Worker();
	w.callme();
	System.out.println("The Thread is Running");
}catch(Exception e){
		System.out.println(e);
	}
	
	}

}
