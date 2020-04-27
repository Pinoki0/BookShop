package com.example.BookShop.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Getter
@Setter
@Document(collection = "books")
public class Book {
    @Transient
    public static final String SEQUENCE_NAME = "books_sequence";

    @Id
    private long id;

    private String title;

    private String description;
//    private BookGenre genre;
//
    private String premiereDate;

//    @DBRef(lazy = true)
//    private PublishingHouse publishingHouse;
//
//    @DBRef
//    private Author author;
//
//    @DBRef
//    private List<BookRating> bookRatings = new ArrayList<>();

//    public Book(String title, String description, String premiereDate) {
//        this.title = title;
//        this.description = description;
//        this.premiereDate = premiereDate;
////        this.premiere = premiere;
////        this.publishingHouse = publishingHouse;
////        this.author = author;
//    }
}
