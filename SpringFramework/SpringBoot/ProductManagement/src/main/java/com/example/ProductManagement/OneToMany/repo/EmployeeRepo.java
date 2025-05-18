package com.example.ProductManagement.OneToMany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductManagement.OneToMany.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
