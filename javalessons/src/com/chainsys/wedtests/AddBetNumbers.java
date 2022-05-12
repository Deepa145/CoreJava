package com.chainsys.wedtests;
import java.math.*;
import java.util.Scanner;
public class AddBetNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AddBetNumbers.equations();
	}
public static void equations()
{
Scanner s1=new Scanner(System.in);
int a=0;
System.out.println("Enter a number 5 To 10");
a=s1.nextInt();
s1.close();
int x=a;
int y=(2*(x*x))+x+5;
System.out.println(y+" ");
}
}
