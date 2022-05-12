package com.chainsys.workingprograms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DemoA {
public static void creatingSingleDimensionInArrays()
{
int firstIntArray[]=new int[10];

int lengthofnumbers=firstIntArray.length;
System.out.println(lengthofnumbers);
for(int x:firstIntArray)
{
System.out.println(x+",");	
}
}
//public static void creatingDimensionArray()
//public static void creatingArrays()
public static void creatingAnotherArray()
{
int days[];
Scanner scanner=new Scanner(System.in);
System.out.println("Enter Size for days");
int size=scanner.nextInt();
scanner.close();
days=new int[size];
int lengthofdays=days.length;
System.out.println("Days"+lengthofdays);
}
public static void createMonthArray()
{
int month[]=new int[12];
int lengthofMonthArray=month.length;
System.out.println("Array length is"+lengthofMonthArray);
for(int i=0;i<lengthofMonthArray;i++)
{
System.out.println(i+"-"+month[1]+",");
}
System.out.println();
month[1]=31;
for(int i=0;i<lengthofMonthArray;i++)
{
	System.out.println(i+"_"+month[i]+",");
}
try
{
month[12]=31;
//month[11]=31;
System.out.println("Hi...chlm");
}
catch(Exception err)
{
System.out.println("Error!!!"+err.getMessage());	
}
}
public static void workingWithArray()
{
 int numberArray[]=new int[10];
 int numArray[]= {2,4,6,8,9};
for(int i=5;i<10;i++)
{
numberArray[i]=-3*i;
System.out.println("Original Contents");
int lengthofTheArray=numberArray.length;
System.out.println("Array len is:"+lengthofTheArray);
for(i=0;i<lengthofTheArray;i++)
{
System.out.println(numberArray[i]+" ");	
}
  System.out.println();
  Arrays.sort(numberArray);
System.out.println("Sorted");
for(int j=0;j<lengthofTheArray;j++)
{
System.out.println(numberArray[j]+" ");	
}
}
}
public static void findTheLengthOfNumbersInArray(double[] nums)
{
double result=nums[15];
int count=nums.length;
for(int i=1;i<count;i++)
{
if(result<nums[i])result=nums[i];
{
System.out.println("The Largest No is"+result);	
}
}
}
public static void bubbleSort()
{
int [] nos= {11,22,333,44,55,666,77,88,999};
System.out.println("Original Values");
for(int index=0;index<nos.length;index++)
{
System.out.println(nos[index]+",");	
}
System.out.println();
int count=nos.length;
int temp=0;
for(int i=0;i<count;i++)
{
	for(int j=0;j<(count-1);j++)
	{
	if(nos[j+1]<nos[j])
	{
		temp=nos[j];
		nos[j]=nos[j+1];
		nos[j+1]=temp;
		temp=0;
	}
	}
	}
System.out.println("Values After Sort");
for(int index=0;index<nos.length;index++)
{
System.out.println(nos[index]+",");	
}
}
}
