package com.example.bookdemo.service;

import com.example.bookdemo.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private final Logger logger;

    public BookServiceImplementation() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
    @Override
    public List<Book> getAll() {
        return List.of(
                new Book(1,"Panchatantra",50,200.45),
                new Book(2,"Tenali Rama",25,70.50),
                new Book(3,"Alladin",75,125.50)
        );
    }

    @Override
    public Book getById(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("Cannot accept the nul");
        }
        return new Book(id,"Title",0,00.0);
    }

    @Override
    public void create(Book book) {
        logger.info(String.format("Created: %s", book.toString()));
    }

    @Override
    public void update(int id, Book book) {
        logger.info(String.format("Updated: %s", book.toString()));
    }

    @Override
    public void deleteById(int id) {
        logger.info(String.format("Deleted: %d", id));
    }
}
