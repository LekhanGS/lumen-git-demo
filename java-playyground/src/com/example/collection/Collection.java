package com.example.collection;

public abstract class Collection {

    private  int size;

    public Collection(int size){
        this.size = size;
    }

    public abstract void add(int x);

    public int getSize(){
        return size;
    }


}
