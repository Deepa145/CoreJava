package com.chainsys.firstlesson;
import java.util.Scanner;
public class Password {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      checkUserName();
	}
public static void checkUserName()
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter yr name");
String userNames=sc.nextLine();
sc.close();
System.out.println("nmae is"+userNames);
char[] nameAsCharacters=userNames.toCharArray();
int lengthOfCharArray=nameAsCharacters.length;
System.out.println("Length of your name is:"+lengthOfCharArray);
if(lengthOfCharArray<3)
{
	System.out.println("Name atleast 3 char");
	return;
}
if(lengthOfCharArray>15)
{
System.out.println("Name not have more then 15 char");
return;
}
String nameInUpperCase=userNames.toUpperCase();
nameInUpperCase=nameInUpperCase.trim();
char[] uppercaseCharArray=nameInUpperCase.toCharArray();
lengthOfCharArray=uppercaseCharArray.length;
int asciiValue=0;
for(int index=0;index<lengthOfCharArray;index++)
{
asciiValue=(int)uppercaseCharArray[index];	
System.out.println("Ascii:"+asciiValue);
if(asciiValue<65||asciiValue>90)
{
if(asciiValue!=32)
{
System.out.println("In valid char in name:");
return;
}
}
}
}
}