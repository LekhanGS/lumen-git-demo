package com.example.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
    private final String apiKey;

    public Demo(@Value("${API_KEY}")String apiKey){
        this.apiKey=apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }
}
