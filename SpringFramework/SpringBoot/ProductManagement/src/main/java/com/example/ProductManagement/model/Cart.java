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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CART")
public class Cart{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARTID")
    private Integer cartId;

    @Column(name = "TOTALAMOUNT")
    private Double totalAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @JsonIgnore
    private Users user;

    @OneToMany(
        mappedBy = "cart",
        cascade = CascadeType.ALL,
        orphanRemoval = true //  You want child entities like CartProduct to be
        //  automatically deleted when they’re removed from the parent’s list.
        // It's useful in one-to-many relationships to avoid manual deletion
    )
    private List<CartProduct> cartProducts = new ArrayList<>();

    public void updateTotalAmount(Double price){
        this.totalAmount += price;
    }

    public Cart(Integer cartId, Double totalAmount, Users user, List<CartProduct> cartProducts) {
        this.cartId = cartId;
        this.totalAmount = totalAmount;
        this.user = user;
        this.cartProducts = cartProducts;
    }

    public Cart() {
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
