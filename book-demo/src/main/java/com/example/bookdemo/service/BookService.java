package com.example.bookdemo.service;

import com.example.bookdemo.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book getById(Integer id);
    void create(Book book);
    void update(int id, Book book);
    void deleteById(int id);
}
