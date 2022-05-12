package com.chainsys.strings;

public class StringLessons {
public static void lessonOne()
{
String firstString="Chainsys";
System.out.println(firstString);
char dataOne[]= {'C','h','a','i','n'};
String secondString=new String(dataOne);
System.out.println(secondString);
String thirdString=new String(new char[] {'C','h','a','i','n'});
System.out.println(thirdString);
}
public static void lessonTwo()
{
String firstString="Hello";	
String secondString="Hello";
/*String thirdString="Hello";
int firstNumber=100;
int secondNumber=100;
int thirdNumber=100;
*/
System.out.println(firstString);
System.out.println(secondString);
firstString="Welcome";
System.out.println(firstString);
System.out.println(secondString);
}
public static void creatingStringInaForLoop()
{
for(int count=0;count<10;count++)
{
String s1="Hello";	
}
}
public static void stringToCharArray()
	{
		
			String secondString="Hope  it  rain";
			System.out.println("Before Trim"+secondString.length());
			secondString=secondString.trim();
			System.out.println("After trim"+secondString.length());
		
		
	
}
/*java.util.Scanner scanner=new java.util.Scanner(System.in);
System.out.println("Enter a word");
String firstString=scanner.nextLine();
scanner.close();
int stringlength=firstString.length();
System.out.println("Length"+stringlength);
char[] data=firstString.toCharArray();
int dataarrayLength=data.length;
System.out.println("Length"+dataarrayLength);
}*/
public static void stringToUpperLower()
{
java.util.Scanner scanner=new java.util.Scanner(System.in);
System.out.println("Enter a Word");
String firstString=scanner.nextLine();
scanner.close();
System.out.println(firstString);
String stringInUpperCase=firstString.toUpperCase();
System.out.println("toUpperCase="+stringInUpperCase);
System.out.println("s1="+firstString);
String stringInLowerCase=firstString.toLowerCase();
System.out.println("toLowerCase="+stringInLowerCase);
System.out.println("s1="+firstString);
String subString=firstString.substring(3);
System.out.println(subString);
subString=firstString.substring(2,6);
System.out.println(subString);
String replacedstring=firstString.replace('a','e');
System.out.println(replacedstring);
boolean flag1=firstString.equals(stringInUpperCase);
System.out.println(flag1);
boolean flag=firstString.equalsIgnoreCase(stringInUpperCase);
System.out.println(flag);
}
public static void testSpilt()
{
String firstString="We r good frds";
String firsttrimmedString=firstString.trim();
String[] data=firsttrimmedString.split(" ");
int count=data.length;
System.out.println("Word Count"+ count);
for(int index=0;index<count;index++)
	System.out.println(data[index]);
}
//reverse the string here
public static void reverse()
{
java.util.Scanner scanner=new java.util.Scanner(System.in);
System.out.println("Enter a Sentence");
String sentence="";
try {
	sentence=scanner.nextLine();
}finally {
	scanner.close();
      }
}
	
public static void main(String[] args)
{
	StringLessons.reverse1(); 
}
public static void reverse1()
{
StringBuffer reverse3=new StringBuffer("Deepa");
System.out.println("reverse3"+reverse3);
reverse3.reverse();
System.out.println("After reverse"+reverse3);
}
}
