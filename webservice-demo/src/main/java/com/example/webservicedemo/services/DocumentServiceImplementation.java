package com.example.webservicedemo.services;

import com.example.webservicedemo.models.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImplementation implements DocumentService {
    private final Logger logger;

    public DocumentServiceImplementation() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    @Override
    public List<Document> getAll() {
        return List.of(
                new Document(1, "India", "India is my country"),
                new Document(2, "Bengaluru", "Bengaluru is my city")
        );
    }

    @Override
    public Document getById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Cannot accept null id");
        }

        return new Document(id, "India", "India is my country");
    }

    @Override
    public void create(Document document) {
        logger.info(String.format("Created: %s", document.toString()));
    }

    @Override
    public void update(int id, Document document) {
        logger.info(String.format("Updated: %s", document.toString()));
    }

    @Override
    public void deleteById(int id) {
        logger.info(String.format("Deleted: %d", id));
    }
}
