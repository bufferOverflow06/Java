package com.example.ProductManagement.OneToMany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductManagement.OneToMany.model.Laptop;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Integer>{
}
