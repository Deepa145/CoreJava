package com.chainsys.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

//import java.lang.reflect.*;
public class ListArrayListDemo {
   /*public static void usingStringArrayList()
   {
	ArrayList<String>stringArrayList=new ArrayList<String>();   
	   System.out.println("Initial size of stringArrayList:"+stringArrayList.size());
	   try
	   {
		   stringArrayList.add("Car");
		   stringArrayList.add("Animal");
		   stringArrayList.add("Auto");
		   stringArrayList.add("Egg");
		   stringArrayList.add("Box");
		   stringArrayList.add("Doll");
		   stringArrayList.add("Fan");
		   stringArrayList.add("Animal");
		   stringArrayList.add("Girl");
		   System.out.println("Size of stringArrayList after additions:"+stringArrayList.size());
		   System.out.println("Contents of stringArrayList:"+stringArrayList);
		   stringArrayList.set(2,"xenas");
		   System.out.println("After Set(2):"+stringArrayList);
		   System.out.println("Last Indexof:'Fan'"+stringArrayList.lastIndexOf("Fan"));
		   stringArrayList.remove("Fan");
		   stringArrayList.remove(2);
		   System.out.println("Size after remove(2):"+stringArrayList.size());
		   System.out.println("Contents of stringArrayList:"+stringArrayList);
		   stringArrayList.trimToSize();
	   }
	   catch(Exception err)
	   {
		   System.out.println(err.getMessage());
	   }*/
	  /* public static void lessonArrayList()
	   {
		 ArrayList<Emp> empArrayList=new ArrayList<Emp>(30);
		 System.out.println("InitiempArrayList size of empArrayList:"+empArrayList.size());
		 try {
			 for(int i=0;i<5;i++)
			 {
				 Emp e1=new Emp(i);
				 e1.Name="Emp"+i;
				 empArrayList.add(e1);
			 }
			 System.out.println("Size of empArrayList after additions:"+empArrayList.size());
			 Emp e3=(Emp) empArrayList.get(4);
			 empArrayList.add(e3);
			 System.out.println("Size of empArrayList after additions:"+empArrayList.size());
			 Emp e4=new Emp(4);
			 e4.Name="Elon Musk";
			 empArrayList.add((e4));
			 System.out.println("Freq of [Emp id-4] in ArrayList-"+Collections.frequency(empArrayList, e3));
			 Iterator<Emp> empIterator=empArrayList.iterator();
			 while(empIterator.hasNext())
			 {
				 Object element=empIterator.next();
				 Emp e1=(Emp) element;
				 System.out.println("\t"+e1.getID()+" "+e1.Name);
			 }
		 }
		 catch(Exception err)
		 {
			 System.out.println("ERROR!!!"+err.getMessage());
				 				 
			 }
		 }
		   
	   
   

   public static void main(String[] args)
   {
	 //  ListArrayListDemo.usingStringArrayList(); 
	  // ListArrayListDemo.lessonArrayList();
	   
   }*/
	   public static void main(String[] args)
	   {
		   LinkedList<String> stringLinkedList=new LinkedList();
		   stringLinkedList.add("F");
		   stringLinkedList.add("B");
		   stringLinkedList.add("D");
		   stringLinkedList.add("E");
		   stringLinkedList.add("C");
		   stringLinkedList.add("F");
		   stringLinkedList.add("B");
		   stringLinkedList.add("D");
		   stringLinkedList.add("E");
		   stringLinkedList.add("C");
		   stringLinkedList.addLast("Z");
		   stringLinkedList.addFirst("A");
		   stringLinkedList.add(1,"A2");
		   Iterator<String> stringIterator=stringLinkedList.iterator();
		   while(stringIterator.hasNext())
		   {
			   System.out.print(stringIterator.next()+" ");
			   
		   }
		   stringLinkedList.remove("F");
		   stringLinkedList.remove(2);
		   stringIterator=stringLinkedList.iterator();
		   while(stringIterator.hasNext())
		   {
			System.out.print(stringIterator.next()+" ");   
		   }
		   stringLinkedList.removeFirst();
		   stringLinkedList.removeLast();
		   stringIterator=stringLinkedList.iterator();
		   while(stringIterator.hasNext())
		   {
			System.out.print(stringIterator.next()+" ");   
		   }
	   }	   
}
