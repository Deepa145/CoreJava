package com.chainsys.collections;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.HashSet;

public class SetHashSetDemo {
public static void main(String[] args)
{
//demoA();
	//demoB();
	demoC();
}
public static void demoA()
{
HashSet<String> string_hs=new HashSet<String>();
string_hs.add("Bee");
string_hs.add("Apple");
string_hs.add("Doll");
string_hs.add(null);
string_hs.add("Egg");
string_hs.add("Cinema");
string_hs.add("Fan");
System.out.println("Size"+string_hs.size());
string_hs.add("Fan");
//string_hs.add("Bee");
System.out.println("Size"+string_hs.size());
Iterator<String> set_itr=string_hs.iterator();
while(set_itr.hasNext())
{
	System.out.println(set_itr.next()+" ");
}
}
public static void demoB()
{
HashSet<Emp> hs=new HashSet<Emp>();
Emp e1=null;
for(int i=0;i<10;i++)
{
e1=new Emp(i);
e1.Name="Emp "+i;
hs.add(e1);
}
System.out.println("Count"+hs.size());
e1=new Emp(9);
hs.add(e1);//does not add duplicate object.ignore
System.out.println("Count"+hs.size());
Iterator<Emp> itr=hs.iterator();
while(itr.hasNext())
{
Emp e2=itr.next();
System.out.println(e2.getID()+" "+e2.Name);
}
}
public static void demoC()
{
TreeSet<String> ts=new TreeSet<String>();
ts.add("Cut");
ts.add("Fun");
ts.add("Assam");
ts.add("Ball");
ts.add("Dog");
ts.add("Aag");
ts.add("Aag");
ts.add("Event");
ts.add("Fan");
//ts.add(null);
ts.add("Delhi");
ts.add("Carrot");
ts.add("Delhi");
ts.add("Ball");
ts.add("Apple");
ts.add("Boy");
ts.add("egg");
ts.add("Fool");
System.out.println("Size "+ts.size());
Iterator<String> itr=ts.iterator();
while(itr.hasNext())
{
System.out.println(itr.next());	
}
}
}
