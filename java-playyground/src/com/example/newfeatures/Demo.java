package com.example.newfeatures;

public interface Demo extends Sample{
    @Override
    default void foo(){
        System.out.println("Default foo in Demo");
    }

}
