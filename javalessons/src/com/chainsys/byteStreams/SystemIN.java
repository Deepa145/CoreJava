package com.chainsys.byteStreams;
import java.io.IOException;
public class SystemIN {
public static void main(String args[]) throws IOException
{
System.out.println(System.in.getClass().getName());
System.out.println(System.out.getClass().getName());
System.out.println("Please Enter a Char:");
int c1=System.in.read();
System.out.println(c1);
char c2=(char)c1;
System.out.println(c2);
}

}
