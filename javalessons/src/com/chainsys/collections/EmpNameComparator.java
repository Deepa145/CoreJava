package com.chainsys.collections;

import java.util.Comparator;

public class EmpNameComparator implements Comparator<EmpComparable> {
public int compare(EmpComparable o1,EmpComparable o2)
{
	int result=0;
	result=o1.Name.compareTo(o2.Name);
	//result=Integer.compare(this.getID(),other.getID());
	return result;
}
}
