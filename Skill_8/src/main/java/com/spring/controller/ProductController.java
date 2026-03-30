package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.model.Product;
import com.spring.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // 1. Add Product (for testing)
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // 2. Get by Category (Derived)
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // 3. Filter by Price Range
    @GetMapping("/filter")
    public List<Product> filterByPrice(
            @RequestParam double min,
            @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // 4. Sorted by Price (JPQL)
    @GetMapping("/sorted")
    public List<Product> getSorted() {
        return repo.getProductsSortedByPrice();
    }

    // 5. Expensive Products (JPQL)
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return repo.getExpensiveProducts(price);
    }
}