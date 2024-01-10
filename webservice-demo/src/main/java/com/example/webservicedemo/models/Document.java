package com.example.webservicedemo.models;

public class Document {
    private int id;
    private String header;
    private String body;

    public Document(int id, String header, String body) {
        this.id = id;
        this.header = header;
        this.body = body;
    }

    public Document() {
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
