package com.example.mavendemo;

public class MathUtils {
    public int square(int n){
        return n * n;
    }

    public double getAreaOfCircle(double radius){
        if (radius<0){
            throw new RuntimeException("negative radius is not allowed");
        }
        return Math.PI *  Math.pow(radius,2);
    }
}
