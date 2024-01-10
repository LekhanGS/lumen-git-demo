package com.example.newfeatures;
@FunctionalInterface

public interface Sample {
    void foo();
//    void goo();
//    String b();

    default void bar(){
        helper();
    }

    private void helper(){
        System.out.println("Sample: bar");
    }
    static void baz(){
        quux();
    }
    private static void quux(){
        System.out.println("Sample: baz");
    }
}
