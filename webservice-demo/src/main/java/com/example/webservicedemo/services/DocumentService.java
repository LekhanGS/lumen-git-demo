package com.example.webservicedemo.services;

import com.example.webservicedemo.models.Document;

import java.util.List;

public interface DocumentService {
    List<Document> getAll();
    Document getById(Integer id);
    void create(Document document);
    void update(int id, Document document);
    void deleteById(int id);
}
