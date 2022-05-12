package com.chainsys.byteStreams;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class FileReader {
    public static void main(String args[])
    {
        int char_from_file;
        FileInputStream fin = null;
        String fname = "d:\\temp\\readme1.txt";
        try
        {
            fin = new FileInputStream(fname);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found");
            return;
        }
        // checking if data is Available
        try
        {
            System.out.println("Is Data Available " + fin.available());
        }
        catch(IOException e)
        {
            System.out.println("File is Closed " + e.getMessage());
        }
        // reading data from the file
        try
        {
            do
            {
                char_from_file = fin.read();
                if(char_from_file != -1) System.out.print((char) char_from_file);
            }while(char_from_file != -1);
        
        }catch(IOException e)
        {
            System.out.println("Error in read " + e.getMessage());
        }
        finally
        {
            try
            {
                if(null != fin) fin.close();
            }catch(IOException e1)
            {
                System.out.println(e1.getMessage());
            }
        }
    }
}
