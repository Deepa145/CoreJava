package com.chainsys.firstlesson;
import java.util.Scanner;
public class SixthPro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      checkUserName();
	}
    public static void checkUserName()
    {
    	Scanner sc=new Scanner(System.in);//input stream
    	//prompt a message in the display console
    	System.out.println("Enter your Name");
    	//get name from the keyboard(input device),and store the name in a local variable
    	String userName=sc.nextLine();
    	sc.close();//closing the input stream
    	//Stream are created and managed by the OS,Scanner is just a handle
    	System.out.println("Name is"+userName);//display the input value received
    	
    	char[] nameAsCharacters=userName.toCharArray();
    	int lengthOfCharArray=nameAsCharacters.length;
    	System.out.println("Len of Ur Name is:"+ lengthOfCharArray);
    	for(int index=0;index<lengthOfCharArray;index++)
    	{
    	 System.out.println(index+" "+nameAsCharacters[index]);
    	}
    }
}
