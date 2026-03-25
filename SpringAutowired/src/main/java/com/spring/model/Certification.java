package com.spring.model;

import org.springframework.stereotype.Component;

@Component   // Makes this a Spring Bean
public class Certification {

    private int id;
    private String name;
    private String dateOfCompletion;

    public Certification() {
        this.id = 1;
        this.name = "Java Certification";
        this.dateOfCompletion = "2026";
    }

    public void display() {
        System.out.println("Certification ID: " + id);
        System.out.println("Certification Name: " + name);
        System.out.println("Date: " + dateOfCompletion);
    }
}