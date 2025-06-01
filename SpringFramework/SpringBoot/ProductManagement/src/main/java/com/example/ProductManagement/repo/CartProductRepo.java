package com.example.ProductManagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductManagement.model.CartProduct;
import com.example.ProductManagement.model.Product;
import com.example.ProductManagement.model.Users;

@Repository
public interface CartProductRepo extends JpaRepository<CartProduct, Integer>{
    Optional<CartProduct> findByCartUserUserIdAndProductProductId(Integer userid, Integer productId);

}
