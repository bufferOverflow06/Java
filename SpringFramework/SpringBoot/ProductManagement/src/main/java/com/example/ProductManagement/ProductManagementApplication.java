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

        //  Category and Product-> OneToMany - ManyToOne
		// OneToMany - ManyToOne
		Product p1 = new Product();
		p1.setProductName("iPhone 16");

		Product p2 = new Product();
		p2.setProductName("Samsung Galaxy S24");

		Product p3 = new Product();
		p3.setProductName("CMF by Nothing");

		List<Product> productList = new ArrayList<>();
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);

		Category c1 = new Category();
		c1.setCategoryName("Mobile phones");
		c1.setProductList(productList);

		p1.setCategory(c1);
		p2.setCategory(c1);
		p3.setCategory(c1);

        productRepo.saveAll(List.of(p1, p2, p3)); // If I do cascade all in product then no need to save category
		// categoryRepo.save(c1); // not required

	}
}
