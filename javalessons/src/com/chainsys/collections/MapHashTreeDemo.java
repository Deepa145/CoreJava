package com.chainsys.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapHashTreeDemo {
	public static void usingGenericTreeDemoA()
	 {
   TreeMap<String, Double> tm = new TreeMap<String, Double> ();

tm.put("John Doe", 3434.34);
tm.put ("Tom Smith", 123.22); 
tm.put ("Jane Baker", 1378.00);
tm.put ("Tod Hall", 99.22);
tm.put ("Ralph Smith", -19.08);
Set<Map.Entry<String, Double>> set = tm.entrySet (); 
Iterator<Map.Entry<String, Double>> i = set.iterator ();
while (i.hasNext ()) {
Map.Entry<String, Double> me = i.next();
System.out.print (me.getKey () + ": ");
System.out.println (me.getValue());
}
System.out.println();
//Deposit 1000 into John Doe's account
double balance = tm.get ("John Doe"); 
tm.put("John Doe", (balance + 1000)); 
System.out.println("John Doe's new balance:");
System.out.println(tm.get ("John Doe"));
}
	public static void main(String[] args)
	{
		MapHashTreeDemo.usingGenericTreeDemoA();
		
	}
}


