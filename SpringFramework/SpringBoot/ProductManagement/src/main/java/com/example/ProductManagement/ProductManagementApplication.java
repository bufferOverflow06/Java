package com.example.ProductManagement;

import com.example.ProductManagement.OneToOne.model.Employee;
import com.example.ProductManagement.OneToOne.model.Laptop;
import com.example.ProductManagement.OneToOne.repo.EmpRepo;
import com.example.ProductManagement.OneToOne.repo.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class ProductManagementApplication implements CommandLineRunner {

    @Autowired
    LaptopRepo laptopRepo;

    @Autowired
    EmpRepo empRepo;

    public static void main(String[] args) {
        SpringApplication.run(ProductManagementApplication.class, args);
        System.out.println("Hello World");
    }

    @Override
    public void run(String... args) throws Exception {

        Laptop laptop = new Laptop();
        laptop.setLaptopName("Asus");

        Employee employee = new Employee();
        employee.setName("jhondoe");
        employee.setLaptop(laptop);

        empRepo.save(employee);

        Optional<Laptop> byId = laptopRepo.findById(1L);
        System.out.println(byId.get().getEmployee().getName());
    }
}

