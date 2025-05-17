package com.example.ProductManagement.OneToMany.repo;

import com.example.ProductManagement.OneToMany.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
