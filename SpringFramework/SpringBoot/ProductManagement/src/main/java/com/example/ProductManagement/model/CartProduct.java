package com.example.ProductManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARTPRODUCT")
public class CartProduct{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CPID")
    private Integer cpID;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CARTID", referencedColumnName = "CARTID")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "PRODUCTID")
    private Product product;

    public CartProduct(Integer cpID, Integer quantity, Cart cart, Product product) {
        this.cpID = cpID;
        this.quantity = quantity;
        this.cart = cart;
        this.product = product;
    }

    public CartProduct() {
    }

    public Integer getCpID() {
        return cpID;
    }

    public void setCpID(Integer cpID) {
        this.cpID = cpID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
