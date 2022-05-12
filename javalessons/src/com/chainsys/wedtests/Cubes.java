package com.chainsys.wedtests;
import java.util.Scanner;
public class Cubes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Cubes.armStrongNumber();
	}
public static void armStrongNumber()
{
int n,a,k,c=0;
java.util.Scanner s1=new java.util.Scanner(System.in);
System.out.println("Enter a Number");
n=s1.nextInt();
k=n;
while(n>0)
{
a=n%10;
c=c+(a*a*a);
n=n/10;
}
if(c==k)
{
System.out.println("Same as Input");	
}
else
{
System.out.println("Different Number");	
}
}
}
