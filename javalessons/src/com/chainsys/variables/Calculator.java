package com.chainsys.variables;
/**
 * 
 * @author deep3108
 *created on:march 2022
 */
public class Calculator {
	/**
	 * add method:will take 2 values using the following parameters
	 * and will add the values.The result of totaling will be returned back to the caller
	 * This a static method.object reference is not required.
	 * 
	 * @param1 of type int
	 * @param2 of type int
	 * @return type in
	 */
public static int add(int param1,int param2)
{
int result=param1+param2;
return result;
}
/**
 * multiply method:will take 2 values using the following parameters
 * and will multiply the values.The result of totaling will be returned back to the caller
 * This a static method.object reference is not required.
 * 
 * @param1 of type int
 * @param2 of type int
 * @return type in
 */
public static int multiply(int param1,int param2)
{
int result=param1*param2;
return result;
}
/**
 * add method:will take 2 values using the following parameters
 * find the difference between the values.The result of totaling will be returned back to the caller
 * This a static method.object reference is not required.
 * 
 * @param1 of type int
 * @param2 of type int
 * @return type in
 */
public static int divide(int param1,int param2)
{
int result=param1/param2;
return result;
}
/**
 * subtract method:will take 2 values using the following parameters
 * and will subtract the values.The result of totaling will be returned back to the caller
 * This a static method.object reference is not required.
 * 
 * @param1 of type int
 * @param2 of type int
 * @return type in
 */
public static int subtract(int param1,int param2)
{
int result=param1-param2;
return result;
}
}
