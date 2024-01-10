package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sample {
    @Autowired

    private Demo demo;

    public Demo getDemo() {
        return null;
    }
}
