package com.example.newfeatures;

public class DemoImplementation implements Demo {
    @Override
    public void foo() {
        System.out.println("Implementation:foo");

    }

    @Override
    public void bar() {
        Demo.super.bar();
    }
}
