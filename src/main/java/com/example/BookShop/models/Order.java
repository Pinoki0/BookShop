package com.example.BookShop.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Document(collection = "orders")
public class Order {
    @Transient
    public static final String SEQUENCE_NAME = "orders_sequence";

    @Id
    private String id;

    private OrderStatus orderStatus = OrderStatus.O;

    private List<Book> books = new ArrayList<>();
}
