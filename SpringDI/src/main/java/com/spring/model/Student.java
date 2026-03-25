package com.spring.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component   // Marks this class as Spring Bean
public class Student {

    @Value("102")
    private int studentId;

    @Value("Rahul")
    private String name;

    @Value("Data Science")
    private String course;

    @Value("2nd Year")
    private String year;

    public void display() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Year: " + year);
    }
}