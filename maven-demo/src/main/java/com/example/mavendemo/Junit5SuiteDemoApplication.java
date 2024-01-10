package com.example.mavendemo;

import com.google.gson.Gson;
import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class Junit5SuiteDemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(MavenDemoApplication.class, args);

        BasicConfigurator.configure();
        LoggingDemo ld = new LoggingDemo();
        ld.doSomething();

        Person p = new Person(12,"abc","adv",180.25);
        Gson gson = new Gson();
        String json = gson.toJson(p);

        Person p1 = gson.fromJson(json, Person.class);

        ConcurrentHashMap<String,Integer> scores= new ConcurrentHashMap<>();
        scores.put("john",45);
        scores.putIfAbsent("john",46);
        scores.putIfAbsent("john",47);

        LocalDate date = LocalDate.now();
        LocalDateTime al = LocalDateTime.now();
        ZonedDateTime il = ZonedDateTime.now();
        Date d = new Date();
        System.out.println(date);
        System.out.println(d);
    }
}
