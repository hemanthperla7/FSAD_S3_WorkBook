package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LibraryController {

    // 1. Welcome API
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Library Application";
    }

    // 2. Count API
    @GetMapping("/count")
    public int count() {
        return 50;
    }

    // 3. Price API
    @GetMapping("/price")
    public double price() {
        return 299.99;
    }
    
    // 4. Get list of books
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java", "Spring", "Python", "DBMS");
    }

    // 5. Get book by ID
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book ID: " + id + " details";
    }
    
    // 6. Search book by title
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }
    
    // 7. Get author details
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Author name is: " + name;
    }
}