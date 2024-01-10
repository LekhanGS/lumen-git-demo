package com.example.newfeatures;

public class SampleImplementation implements Sample {
    @Override
    public void foo() {
        System.out.println("SampleImplementation : foo");
    }

    @Override
    public void bar() {
        System.out.println("SampleImplementation : bar");
    }
}
