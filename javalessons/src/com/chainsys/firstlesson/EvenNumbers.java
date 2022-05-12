package com.chainsys.firstlesson;

public class EvenNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         evenNumber();
	}
	public static void evenNumber()
	{
		for(int i=1;i<=100;i++)	
		{
			if(i%2==0)
			{
				System.out.print("The even Numbers is:");
				System.out.print(i);
			}
			else
			{
				System.out.println("");
			}
		}
	}

}
