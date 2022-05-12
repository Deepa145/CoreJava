package com.chainsys.wedtests;

public class PrintNumbers
{
public static void main(String[] args)
{
for(int i=1;i<=100;i++)
{
if(i%3==0)
{
System.out.println("Multiples of Three"+"-"+i+"=Fizz");
}
if(i%5==0)
{
System.out.println("Multiples of Five"+"-"+i+"=Buzz");
}
if(i%3==0 && i%5==0)
{
System.out.println("Multiples of both Three & Five"+"-"+i+"=FizzBuzz");
}
}
}
}
