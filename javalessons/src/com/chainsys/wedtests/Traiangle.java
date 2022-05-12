package com.chainsys.wedtests;

public class Traiangle {

	public static void main(String[] args) {
		Traiangle.diamand();
	}
		// TODO Auto-generated method stub
		public static void diamand()
		{
			int countA=0;
	    	for(countA=1;countA<=9;countA++)
	    	{
	    		for(int countB=9;countB>countA;countB--)
	    		{
	    			System.out.print(".");
	   
	    		}
	    		for(int countC=countA;countC>=1;countC--)
	    		{
	    			System.out.print(countC);
	    		}
	    		for(int countD=2;countD<=countA;countD++)
	    		{
	    			System.out.print(countD);
	    		}
	    		System.out.println();	
	    	}
	   
	}

}
