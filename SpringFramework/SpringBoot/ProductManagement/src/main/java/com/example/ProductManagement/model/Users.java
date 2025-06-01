package com.example.ProductManagement.model;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID")
    private Integer userId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "USERS_ROLE",
        joinColumns = @JoinColumn(name = "USERID", referencedColumnName = "USERID"),
        inverseJoinColumns = @JoinColumn(name = "ROLEID", referencedColumnName = "ROLEID")
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "seller")
    private List<Product> products;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    public Users(Integer userId, String username, String password, List<Role> roles, List<Product> products,
            Cart cart) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.products = products;
        this.cart = cart;
    }

    public Users() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
            .map(r -> new RoleGrantedAuthority(r.getRoleName()))
            .collect(Collectors.toList());
    }

    // or use this

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     List<GrantedAuthority> authorities = new ArrayList<>();
    //     for (Role role : this.roles) {
    //         authorities.add(new RoleGrantedAuthority(role.getRoleName()));
    //     }
    //     return authorities;
    // }

    // setting the values for roles

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Getters and setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
