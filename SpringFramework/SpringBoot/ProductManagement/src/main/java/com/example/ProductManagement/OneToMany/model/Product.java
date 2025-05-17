package com.example.ProductManagement.OneToMany.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private Category category;

    public Product(Integer productId, String productName, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category=" + category +
                '}';
    }

    public Product() {
    }
}
