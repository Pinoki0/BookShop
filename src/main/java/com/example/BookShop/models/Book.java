package com.example.BookShop.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "books")
public class Book {
    @Transient
    public static final String SEQUENCE_NAME = "books_sequence";

    @Id
    private String id;

    private String name;

    private BookGenre genre;

    private Date premiere;

    @DBRef
    private PublishingHouse publishingHouse;

    @DBRef
    private Author author;

    @DBRef
    private List<BookRating> bookRatings = new ArrayList<>();
}
