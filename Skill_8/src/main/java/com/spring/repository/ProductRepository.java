package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // 🔹 Derived Query Methods

    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // 🔹 JPQL Queries

    // Sort products by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSortedByPrice();

    // Fetch products above a price
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> getExpensiveProducts(double price);

    // Fetch products by category (JPQL)
    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> getProductsByCategoryJPQL(String category);
}