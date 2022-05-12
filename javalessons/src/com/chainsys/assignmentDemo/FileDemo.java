package com.chainsys.assignmentDemo;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileDemo.createFile();
	}

public static void createFile()
{
File file=new File("C:\\Deepa\\Flower");
boolean p1=file.exists();
System.out.println(p1);
if(p1==false)
file.exists();
System.out.println("True or False: "+p1);
	
if(p1==false)
	file.mkdirs();
p1=file.exists();
 System.out.println("Yes or No:  "+p1);
}
}







