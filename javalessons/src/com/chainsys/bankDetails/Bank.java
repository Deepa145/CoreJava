package com.chainsys.bankDetails;

public class Bank {
	public static int currentBalance;
	public static String customerName;
	public static int accountNumber;
	public static void deposite(int paraAmount)
	{
	currentBalance=currentBalance+paraAmount;	
	}
	public static int withdraw(int paraAmount)
	{
	System.out.println("withdraw amount is"+paraAmount);
	currentBalance=currentBalance-paraAmount;
	return paraAmount;
	}
	public static void openAccount(String paraName,int paraAccountNumber)
	{
		System.out.println("The Account Holder Name is:"+" "+paraName);
		System.out.println("The Account number is:"+" "+paraAccountNumber);
		customerName=paraName;
		accountNumber=paraAccountNumber;
	}
	}