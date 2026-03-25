package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Student;

public class MainApp {

    public static void main(String[] args) {

        // Load Spring Container
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get Bean
        Student s = context.getBean(Student.class);

        // Display values
        s.display();
    }
}