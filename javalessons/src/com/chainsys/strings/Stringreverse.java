package com.chainsys.strings;

public class Stringreverse {

	public static void main(String[] args) {
// TODO Auto-generated method stub
		
		
String str1="Chainsys";
String str2=" ";
for(int a=str1.length()-1;a>=0;a--)
{
str2=str2+str1.charAt(a);	
}
System.out.println(str2);
	}

}
