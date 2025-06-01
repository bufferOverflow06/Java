package com.example.ProductManagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductManagement.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
    List<Product> findByProductNameContainingIgnoreCaseOrCategoryCategoryNameContainingIgnoreCase(String productName, String CategoryName);
    Optional<Product> findById(Integer productId);
}
