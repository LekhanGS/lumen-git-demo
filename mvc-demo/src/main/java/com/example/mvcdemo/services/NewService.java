package com.example.mvcdemo.services;

import org.springframework.stereotype.Service;

@Service
public class NewService {
    public Object getNews(String country, int year){
        return new News(country, year);
    }
}
