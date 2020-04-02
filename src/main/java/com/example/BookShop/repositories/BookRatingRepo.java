package com.example.BookShop.repositories;

import com.example.BookShop.models.BookRating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRatingRepo extends MongoRepository<BookRating, String> {
}
