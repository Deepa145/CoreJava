package com.chainsys.collections;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writeobj
{
  public static void main(String arg[]) throws IOException //throws Exception
  {
    FileOutputStream fos =null;
    ObjectOutputStream oos =null;
    java.util.Scanner scanner=null;
    try
    {
        fos=new FileOutputStream ("d:\\temp\\emp1.dat") ;
        oos=    new ObjectOutputStream(fos) ;
         scanner=new java.util.Scanner(System.in);
        System.out.println("Enter Emp ID");
        String sid=scanner.nextLine();
        System.out.println("Enter EmpName");
        String sName=scanner.nextLine();        
        Emp firstemp  =  new Emp(Integer.parseInt(sid),sName) ;        
        oos.writeObject(firstemp) ;
        oos.flush();
        System.out.println("Emp Object Saved "+firstemp.hashCode());
    }
    catch(Exception e)
    {
        System.out.println("Exception during serialization: " + e);
    }
    finally
    {
        try
        {
            oos.close();
            scanner.close();        }
        catch(Exception e)
        {
            System.out.println("Exception during oos.close: " + e);
        }
    }
  }
}