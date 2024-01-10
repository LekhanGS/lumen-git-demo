package com.example;

import java.util.Objects;

public class Person {
    private final int id ;
    private final String FullName;

    public Person(int id, String fullName) {
        this.id = id;
        FullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return FullName;
    }
    @Override
    public boolean equals(Object obj){
        Person p = (Person) obj;
        return  this.getId() == p.getId()
                && this.getFullName().equals(p.getFullName());
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, FullName);
    }
}
