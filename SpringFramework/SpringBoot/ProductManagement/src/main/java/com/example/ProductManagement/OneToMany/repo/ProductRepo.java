package com.example.ProductManagement.OneToMany.repo;

import com.example.ProductManagement.OneToMany.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
