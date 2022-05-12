/**
 * 
 */
package com.chainsys.bankDetails;

/**
 * @author deep3108
 *
 */
public class BankTestClass {

	/**
	 * @param args
	 */
	public static void testDeposite()
	{
	System.out.println("Before Balance"+Bank.currentBalance);
	Bank.deposite(10000);
	System.out.println("After Balance"+Bank.currentBalance);
	}
	public static void testWithdraw()
	{
	System.out.println("Before Balance"+Bank.currentBalance);
	int withdraw=Bank.withdraw(5000);
	System.out.println("total amount is"+withdraw);
	System.out.println("After Balance"+Bank.currentBalance);
	}
	public static void testOpenaccount()
	{
		Bank.openAccount("Deepa", 163627687);
		System.out.println(Bank.customerName);
		System.out.println(Bank.accountNumber);
	}
	}