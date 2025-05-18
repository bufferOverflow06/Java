package com.example.ProductManagement;

import com.example.ProductManagement.OneToMany.model.Category;
import com.example.ProductManagement.OneToMany.model.Employee;
import com.example.ProductManagement.OneToMany.model.Laptop;
import com.example.ProductManagement.OneToMany.model.Product;
import com.example.ProductManagement.OneToMany.repo.CategoryRepo;
import com.example.ProductManagement.OneToMany.repo.EmployeeRepo;
import com.example.ProductManagement.OneToMany.repo.LaptopRepo;
import com.example.ProductManagement.OneToMany.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProductManagementApplication implements CommandLineRunner {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	CategoryRepo categoryRepo;

    @Autowired
    LaptopRepo laptopRepo;

    @Autowired
    EmployeeRepo employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


        // Employee and Laptop -> OneToMany - ManyToOne
        Employee e1 = new Employee();
        e1.setEmpName("jhondoe");

        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        Laptop l2 = new Laptop();
        l2.setBrand("Dell");
        Laptop l3 = new Laptop();
        l3.setBrand("Apple");

        l1.setEmployee(e1);
        l2.setEmployee(e1);
        l3.setEmployee(e1);

        laptopRepo.saveAll(List.of(l1, l2, l3));
        // above works
	}
}
