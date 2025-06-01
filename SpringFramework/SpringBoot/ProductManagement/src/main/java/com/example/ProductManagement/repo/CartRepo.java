package com.example.ProductManagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductManagement.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
    Cart findByUserUsername(String username);
}
