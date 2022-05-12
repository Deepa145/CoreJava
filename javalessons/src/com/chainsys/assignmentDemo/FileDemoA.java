package com.chainsys.assignmentDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
public class FileDemoA {

		    public static void main(String[] args)throws IOException {
		        
		       // createFile();
		       // renameFile();
		       // AppendToFileUsingFileWriter();
		    	//ReadFileName();
		    	//deleteFile();
		    	//moveFile();
		    	//modifyFile();
		        copyFile("D:\\temp\\Ravi.txt","D:\\temp\\copy","Ravi.txt");
		    }
		    public static void createFile()
		    {
		    try {  
		    // Creating an object of a file  
		    File f0 = new File("D:Filekjdsjdsjb.txt");   
		      if (f0.createNewFile()) {  
		      System.out.println("File " + f0.getName() + " is created successfully.");  
		      } else {  
		      System.out.println("File is already exist in the directory.");  
		      }  
		      } catch (IOException exception) {  
		      System.out.println("An unexpected error is occurred.");  
		      exception.printStackTrace();  
		      }   
		    }
		    public static void renameFile()
		    {
		        // Create an object of the File class
		        // Replace the file path with path of the directory
		        File file = new File("D:Filekjdsjdsjb.txt");
		  
		        // Create an object of the File class
		        // Replace the file path with path of the directory
		        File rename = new File("D:FileOperatiggon.txt");
		  
		        // store the return value of renameTo() method in flag
		        boolean flag = file.renameTo(rename);
		  
		        // if renameTo() return true then if block is
		        // executed
		        if (flag == true) {
		            System.out.println("File Successfully Rename");
		        }
		        // if renameTo() return false then else block is
		        // executed
		        else {
		            System.out.println("Operation Failed");
		        }
		    }
		    public static void AppendToFileUsingFileWriter()
		    {
		    try(FileWriter fw = new FileWriter("D:Filekjdsjdsjb.txt", true);
		         BufferedWriter bw = new BufferedWriter(fw);
		         PrintWriter out = new PrintWriter(bw))
		        {
		            out.println("the text");
		            //more code
		            out.println("more tegsdgdgdsxt");
		            //more code
		            System.out.println("Data added");
		        } catch (IOException e) {
		            //exception handling left as an exercise for the reader
	}

}
		    public static void deleteFile()
		    {
		        String fileName = "D:Filekjdsjdsjb.txt";
		        try {
		            Files.delete(Paths.get(fileName));
		            System.out.println("File Deleted");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }}
		  public static void ReadFileName() throws IOException
		   {
		     String fileName ="D:Deepa.txt";
		     File file = new File(fileName);
		     FileReader fr = new FileReader(file);
		     BufferedReader br = new BufferedReader(fr);
		     String line;
		     while((line = br.readLine()) != null)
		     {
		     System.out.println(line);
		        }
		     }
		 
		  public static void modifyFile()throws IOException
	        {
	            String source = "D:\\FileOperatiggon.txt";
	            Scanner sc = new Scanner(new File(source));
	            StringBuffer buffer1 = new StringBuffer();
	            while (sc.hasNextLine()) {
	               buffer1.append(sc.nextLine()+System.lineSeparator());
	            }
	            String fileContents = buffer1.toString();
	            System.out.println("Contents of the file: "+fileContents);
	            sc.close();
	            String oldLine = "Deepa";
	            String newLine = "I am a Naughty girl";
	            fileContents = fileContents.replaceAll(oldLine, newLine);
	            FileWriter writer = new FileWriter(source);
	            System.out.println("");
	            System.out.println("new data: "+fileContents);
	            writer.append(fileContents);
	            writer.flush();
	        }

		  public static boolean copyFile(String sourcePath,String destFolderPath,  String fileName) {
              boolean fileMoved = true;

               try {

                   Files.copy(Paths.get(sourcePath), Paths.get(destFolderPath, fileName),StandardCopyOption.REPLACE_EXISTING);
                   System.out.println("File is copy Successful");

               } catch (Exception e) {

                   fileMoved = false;
                   System.out.println("Error!!!"+e.getMessage());
               }

               return fileMoved;
              }
		  public static void moveFile() throws IOException
		    {
		        File file = new File("D:\\temp\\FileOperatiggon.txt");
		        // renaming the file and moving it to a new location
		        if(file.renameTo
		           (new File("D:\\Ravi")))
		        {
		            // if file copied successfully then delete the original file
		            file.delete();
		            System.out.println("Moved successfully");
		        }
		        else
		        {
		            System.out.println("Failed to move the file");
		        }
		    }
		  
}