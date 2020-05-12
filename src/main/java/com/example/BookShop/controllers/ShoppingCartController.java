package com.example.BookShop.controllers;

import com.example.BookShop.models.ShoppingCart;
import com.example.BookShop.repositories.ShoppingCartRepo;
import com.example.BookShop.services.DatabaseSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@Controller
@RequestMapping("/api")
public class ShoppingCartController {
    @Autowired
    ShoppingCartRepo shoppingCartRepo;

    @Autowired
    DatabaseSequenceService sequenceGenerator;

    @PostMapping("/shoppingCart/add")
    public ResponseEntity<ShoppingCart> createBook() {
        try {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setUserId("Eryk");
            shoppingCartRepo.save(shoppingCart);
            return new ResponseEntity<>(shoppingCart, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/shoppingCart")
    public ResponseEntity<ShoppingCart> getShoppingCart() {
        Optional<ShoppingCart> shoppingCart = Optional.ofNullable(shoppingCartRepo.findByUserId("Eryk"));

        return shoppingCart.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

