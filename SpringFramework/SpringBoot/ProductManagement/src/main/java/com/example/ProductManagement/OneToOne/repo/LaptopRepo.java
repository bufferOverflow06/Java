package com.example.ProductManagement.OneToOne.repo;

import com.example.ProductManagement.OneToOne.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Long> {

}
