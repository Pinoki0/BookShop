package com.example.BookShop.repositories;

import com.example.BookShop.models.OrderStatus;
import com.example.BookShop.models.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepo extends MongoRepository<ShoppingCart,String> {
    ShoppingCart findByUserId(String userId);
}
