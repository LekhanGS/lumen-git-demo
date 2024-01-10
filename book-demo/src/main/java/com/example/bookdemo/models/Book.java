package com.example.bookdemo.models;

public class Book {
    private int id;
    private String title;
    private int pages;
    private double price;

    public Book(int id, String title, int pages, double price) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.price = price;
    }

    public Book(){
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}
