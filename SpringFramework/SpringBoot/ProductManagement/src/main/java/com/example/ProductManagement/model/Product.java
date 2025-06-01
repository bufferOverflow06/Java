package com.example.ProductManagement.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCTID")
    private Integer productId;

    @Column(name = "PRODUCTNAME")
    private String productName;

    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SELLERID", referencedColumnName = "USERID")
    @JsonIgnore
    private Users seller;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<CartProduct> cartProducts = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
    private Category category;

    public Product(Integer productId, String productName, Double price, Users seller, List<CartProduct> cartProducts,
            Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.seller = seller;
        this.cartProducts = cartProducts;
        this.category = category;
    }

    public Product() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
