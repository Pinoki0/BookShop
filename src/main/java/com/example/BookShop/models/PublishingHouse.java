package com.example.BookShop.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "publishing_house")
public class PublishingHouse {
    @Transient
    public static final String SEQUENCE_NAME = "publishing_house_sequence";

    @Id
    private String id;

    private String name;

    private String surname;

    @DBRef
    private List<Book> books = new ArrayList<>();
}
