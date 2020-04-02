package com.example.BookShop.repositories;

import com.example.BookShop.models.BookGenre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookGenreRepo extends MongoRepository<BookGenre, String> {
}
