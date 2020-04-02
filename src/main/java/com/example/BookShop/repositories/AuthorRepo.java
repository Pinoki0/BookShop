package com.example.BookShop.repositories;

import com.example.BookShop.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends MongoRepository<Author, String> {
}
