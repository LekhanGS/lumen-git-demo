package com.example.mavendemo;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private double height;

    public Person(int id, String firstName, String lastName, double height) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
