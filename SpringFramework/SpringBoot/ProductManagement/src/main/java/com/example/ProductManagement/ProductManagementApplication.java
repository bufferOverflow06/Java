package com.example.ProductManagement;

import com.example.ProductManagement.OneToMany.model.Category;
import com.example.ProductManagement.OneToMany.model.Product;
import com.example.ProductManagement.OneToMany.repo.CategoryRepo;
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

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

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



		categoryRepo.save(c1);

//		 If cascade = CascadeType.ALL is not given in Category then we
//		have to manually do this as no product will be saved automatically
//		productRepo.save(p1);
//		productRepo.save(p2);
//		productRepo.save(p3);

	}
}
