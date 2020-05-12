package com.example.BookShop.repositories;

import com.example.BookShop.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends MongoRepository<Book, String> {
    List<Book> findByAvailableAndTitleContaining(boolean available, String title);
    List<Book> findByAvailable(boolean available);
    Book findById(long id);
    void deleteById(long id);

}
