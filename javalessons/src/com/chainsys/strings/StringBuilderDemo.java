package com.chainsys.strings;

public class StringBuilderDemo {
	public static void testA()
	{
String firstString="Hello how r u";
StringBuilder stringbuilder=new StringBuilder();
//System.out.println("length"+stringbuilder.length());
//System.out.println("Capacity"+stringbuilder.capacity());
stringbuilder.append(firstString);
System.out.println("buffer"+stringbuilder);
System.out.println("length"+stringbuilder.length());
System.out.println("Capacity"+stringbuilder.capacity());
firstString="wish it rains this week";
stringbuilder.append(firstString);
System.out.println("buffer"+stringbuilder);
System.out.println("length"+stringbuilder.length());
System.out.println("Capacity"+stringbuilder.capacity());
stringbuilder.trimToSize();
System.out.println("length"+stringbuilder.length());
System.out.println("Capacity"+stringbuilder.capacity());
stringbuilder.replace(3,8,"This is a test==");
System.out.println("replace="+ stringbuilder);
stringbuilder.insert(10,"This is august=");
System.out.println("insert"+stringbuilder);
System.out.println("length"+stringbuilder.length());
System.out.println("Capacity"+stringbuilder.capacity());
stringbuilder.delete(5,20);
System.out.println("delete"+stringbuilder);
System.out.println("length"+stringbuilder.length());
System.out.println("Capacity"+stringbuilder.capacity());
System.out.println("Before"+stringbuilder);
System.out.println("Before reverse="+stringbuilder);
stringbuilder.reverse();
System.out.println("After reverse="+stringbuilder);
}
}
