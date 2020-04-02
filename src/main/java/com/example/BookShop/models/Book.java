package com.example.BookShop.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
    private PublishingHouse publishingHouse;
    private Author author;
    private List<BookRating> bookRatings = new ArrayList<>();


    public Book(String id, String name, BookGenre genre, Date premiere, PublishingHouse publishingHouse, Author author, BookRating bookRating) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.premiere = premiere;
        this.publishingHouse = publishingHouse;
        this.author = author;
        this.bookRatings.add(bookRating);
    }
}
