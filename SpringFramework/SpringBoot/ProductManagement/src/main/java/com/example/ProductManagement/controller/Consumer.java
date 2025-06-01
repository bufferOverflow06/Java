package com.example.ProductManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping; import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductManagement.ErrorBean.CustomException;
import com.example.ProductManagement.model.Cart;
import com.example.ProductManagement.model.CartProduct;
import com.example.ProductManagement.model.Category;
import com.example.ProductManagement.model.Product;
import com.example.ProductManagement.repo.CartProductRepo;
import com.example.ProductManagement.repo.CartRepo;
import com.example.ProductManagement.repo.ProductRepo;
import com.example.ProductManagement.utilities.Utility;

@RestController
@RequestMapping("/api/auth/consumer")
@PreAuthorize("hasAuthority('CONSUMER')") // who has `CONSUMER` authority only he can enter this path
public class Consumer{

    @Autowired
    CartRepo cartRepo;

    @GetMapping("/cart")
    public ResponseEntity<Object> getCart(){
        String username = Utility.getUserFromContext();
        Cart cart = cartRepo.findByUserUsername(username);
        return ResponseEntity.ok(cart);
    }

    @Autowired
    CartProductRepo cartProductRepo;

    @Autowired
    ProductRepo productRepo;


    @PostMapping("/cart")
    public ResponseEntity<Object> postCart(@RequestBody Product product){

        String username = Utility.getUserFromContext();
        Cart cart = cartRepo.findByUserUsername(username);
        List<CartProduct> cartProducts = cart.getCartProducts();

        // 1.Validate if product exists
        // Product can only be added to consumer's cart if that product is present in the Product table.
        Product existingProduct = productRepo.findById(product.getProductId())
            .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Product not found"));

        // 2. The product should not be already in the consumer's cart
        // cart contains only totalAmount for a user and userid(consumer)
        // so basically I have to add this product to CARTPRODUCT first
        // CARTPRODUCT has CPID, QUANTITY, CARTID, PRODUCTID
        // before that I have to check if the CARTPRODUCT for the particular user
        // have that product, if it is `there or not there` first add the product to cartProduct
        // then add it to the cart
        long count = cartProducts.stream().filter(cartProduct -> cartProduct.getProduct().getProductId() == product.getProductId()).count();
        System.out.println("Count Value: " + count);
        if(count != 0){
            throw new CustomException(HttpStatus.CONFLICT, "product already exist in cartProduct");
        }
        //
        // boolean productExists = false;
        // for(CartProduct cp : cartProducts){
        //     if(cp.getProduct().getProductId() == product.getProductId()){
        //         productExists = true;
        //         break;
        //     }
        // }
        // if(productExists) throw new CustomException(HttpStatus.CONFLICT, "product already exist");
        //
        //
        // Load product from DB, don't use detached product from request directly
        // Product persistedProduct = productRepo.findById(product.getProductId())
        // .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Product not found"));

        CartProduct cartProduct = new CartProduct();
        cartProduct.setCart(cart);
        cartProduct.setProduct(product);
        cartProduct.setQuantity(1);
        cartProductRepo.save(cartProduct);

        cart.updateTotalAmount(product.getPrice());
        cartProducts.add(cartProduct);
        cart.setCartProducts(cartProducts);
        cartRepo.save(cart);

        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/cart")
    public ResponseEntity<Object> deleteCart(@RequestBody Product product){
        String username = Utility.getUserFromContext();
        Cart cart = cartRepo.findByUserUsername(username);

        List<CartProduct> cartProducts = cart.getCartProducts();

        CartProduct cartProductReq = null;

        for(CartProduct cp : cartProducts){
            if(cp.getProduct().getProductId() == product.getProductId()){
                cartProductReq  = cp;
                break;
            }
        }
        if(cartProductReq == null){
            throw new CustomException(HttpStatus.BAD_REQUEST, "No Product Found");
        }

        cart.updateTotalAmount(-cartProductReq.getQuantity() * product.getPrice());

        cartProducts.remove(cartProductReq);

        cartRepo.save(cart);

        System.out.println(cart.getCartId());
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Object> putCart(@RequestBody CartProduct cartProduct){

        String username = Utility.getUserFromContext();
        Cart cart = cartRepo.findByUserUsername(username);

        List<CartProduct> cartProducts = cart.getCartProducts();

        Optional<CartProduct> productOptional = cartProductRepo.findByCartUserUserIdAndProductProductId(cart.getUser().getUserId(), cartProduct.getProduct().getProductId());

        if(productOptional.isPresent()){
            CartProduct cartProductOld = productOptional.get();
            double priceOff = (cartProduct.getQuantity() - cartProductOld.getQuantity()) * cartProductOld.getProduct().getPrice();
            cartProductOld.setQuantity(cartProductOld.getQuantity());
            cartProductRepo.save(cartProductOld);
            cart.updateTotalAmount(priceOff);
            cartRepo.save(cart);
        }
        else{
            cartProduct.setCart(cart);
            cartProductRepo.save(cartProduct);
            cartProducts.add(cartProduct);
            cart.updateTotalAmount(cartProduct.getQuantity() * cartProduct.getProduct().getPrice());

            cart.setCartProducts(cartProducts);
            cartRepo.save(cart);
        }

        if(cartProduct.getQuantity() == 0){
            deleteCart(cartProduct.getProduct());
        }

        return ResponseEntity.ok().build();
    }

}
