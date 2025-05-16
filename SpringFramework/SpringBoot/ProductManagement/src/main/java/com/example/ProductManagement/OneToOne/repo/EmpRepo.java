package com.example.ProductManagement.OneToOne.repo;

import com.example.ProductManagement.OneToOne.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

}
