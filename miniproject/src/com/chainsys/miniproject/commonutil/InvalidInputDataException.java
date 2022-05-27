package com.chainsys.miniproject.commonutil;

public class InvalidInputDataException  extends Exception{
    public InvalidInputDataException() {
        System.out.println("This is not valid");
    }
    public InvalidInputDataException(String message) {
        System.out.println(message);
    }
}