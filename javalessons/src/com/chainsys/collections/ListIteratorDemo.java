package com.chainsys.collections;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Iterator;

import java.util.ListIterator;

public class ListIteratorDemo {
public static void main(String args[])
{
ArrayList<String> stringArrayList=new ArrayList<String>();
String s1="B";
stringArrayList.add("C");
stringArrayList.add(s1);
stringArrayList.add("A");
stringArrayList.add("E");
stringArrayList.add(s1);
stringArrayList.add("D");
stringArrayList.add("F");
stringArrayList.add(s1);
Iterator<String> string_itr=stringArrayList.iterator();
while(string_itr.hasNext())
{
System.out.println(string_itr.next()+" ");	
}
System.out.println();
ListIterator<String> string_list_itr=stringArrayList.listIterator();
while(string_list_itr.hasNext())
{
String element=string_list_itr.next();
string_list_itr.set(element+"--");
}
string_itr=stringArrayList.iterator();
while(string_list_itr.hasNext())
{
Object element=string_itr.next();
System.out.println(element+" ");
}
System.out.println();
while(string_list_itr.hasPrevious())
{
String element=string_list_itr.previous();
System.out.println(element+" ");
}

}
}
