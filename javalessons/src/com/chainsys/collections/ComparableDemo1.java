package com.chainsys.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class ComparableDemo1 {
	public static void main(String[] args) 
	{
		sortComparableEmp();
	}
	public static void compareEmp()
	{
		Emp e1= new Emp(100);
		e1.Name="Sam";
		Emp e2=new Emp(200);
		e2.Name="Musk";
		Emp e3=new Emp(300);
		e3.Name="Jobs";
		List<Emp>empList=new ArrayList<>();
		empList.add(e2);
		empList.add(e3);
		empList.add(e1);
		System.out.println(empList);
//		Collections.sort(empList);
		System.out.println(empList);
		
	}
	public static void sortComparableEmp()
	{
		EmpComparable e1= new EmpComparable(100);
		e1.Name="Sam";
		EmpComparable e2=new EmpComparable(200);
		e2.Name="Musk";
		EmpComparable e3=new EmpComparable(300);
		e3.Name="Jobs";
		List<EmpComparable>empList=new ArrayList<>();
		empList.add(e2);
		empList.add(e3);
		empList.add(e1);
		System.out.println(empList);
		Iterator<EmpComparable> emp_iterator=empList.iterator();
		while(emp_iterator.hasNext())
		{
			System.out.println(emp_iterator.next().getID());
		}
		Collections.sort(empList);
		System.out.println("---------");
		emp_iterator=empList.iterator();
		while(emp_iterator.hasNext())
		{
			System.out.println(emp_iterator.next().getID());
		}
		EmpNameComparator empComparator = new EmpNameComparator();
		
		Collections.sort(empList,empComparator);
		System.out.println("---------");
		emp_iterator=empList.iterator();
		while(emp_iterator.hasNext())
		{
			EmpComparable emp=emp_iterator.next();
			System.out.println(emp.getID()+" "+emp.Name);
		}
		
	}
}
