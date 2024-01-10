package com.example;

public class Util {
    private String message;

    static double pi = 3.12857;

    static {
        System.out.println("static running......");
    }


    public Util(String message){
        this.message = message;
    }

    public void printMessage(){
        System.out.println(message);
    }

    public static int square(int n){
        return n * n ;
    }
}
