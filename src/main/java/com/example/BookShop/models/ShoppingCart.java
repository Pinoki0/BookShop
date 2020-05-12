package com.example.BookShop.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "shoppingCart")
public class ShoppingCart {
    @Transient
    public static final String SEQUENCE_NAME = "shoppingCart_sequence";

    @Id
    private long id;

    private String userId;

    private List<Order> orders = new ArrayList<>();
}
