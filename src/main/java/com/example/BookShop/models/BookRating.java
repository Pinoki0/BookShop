package com.example.BookShop.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
@Getter
@Setter
@Document(collection = "book_rating")
public class BookRating {
    @Transient
    public static final String SEQUENCE_NAME = "book_rating_sequence";

    @Id
    private String id;

    private String bookId;

    private String comment;

    @Range(min = 1, max = 5)
    private int bookRating;

    private Date ratingDate;
}
