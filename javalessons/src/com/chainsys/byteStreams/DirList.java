package com.chainsys.byteStreams;
import java.io.File;
public class DirList
{
public static void main(String [] args)
{
   String dirname="d:/temp";
    File file = new File(dirname);
    String listoffilenamesindirectory[]=null;
    if(file.isDirectory())
    {
        System.out.println(dirname+" is a Directory");
        listoffilenamesindirectory=file.list();
        for(int i=0;i<listoffilenamesindirectory.length;i++)
        {
            File f=new File(dirname+ "/"+listoffilenamesindirectory[i]);
            if(f.isDirectory())
            {
                System.out.println("\t<"+f.getName()+"> is a sub directory or Folders");
            }
            else
            {
                System.out.println("\t<"+f.getName()+"is a file");
            }
        }
    }

  }
}
