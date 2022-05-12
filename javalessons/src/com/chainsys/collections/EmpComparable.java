package com.chainsys.collections;

public class EmpComparable implements Comparable<EmpComparable>{
    
    private final int id;
    public String Name;
    
    public EmpComparable(int vl)
    {
        id=vl;
    }
    public int getID()
    {
        return id;
    }
    public boolean equals (Object obj)
    {
        Class cl=obj.getClass();
        boolean flag=false;
        if(cl==this.getClass())
        {
            EmpComparable other=(EmpComparable)obj;
            if(this.hashCode()==other.hashCode())
                flag=true;
        }
        return flag;
    }
    public int hashCode()
    {
        return this.id;
    }
    public int compareTo(EmpComparable other)
    {
        int result=0;
        result=Integer.compare(this.getID(), other.getID());
        return result;
    }
}