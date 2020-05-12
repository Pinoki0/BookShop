package com.example.BookShop.controllers;

import com.example.BookShop.models.Book;
import com.example.BookShop.repositories.BookRepo;
import com.example.BookShop.services.DatabaseSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@Controller
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    DatabaseSequenceService sequenceGenerator;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(@RequestParam(required = false) String title) {
        try {
            List<Book> books = new ArrayList<>();

            if (title == null)
                books.addAll(bookRepo.findByAvailable(true));
            else
                books.addAll(bookRepo.findByAvailableAndTitleContaining(true,title));

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {
        Optional<Book> book = Optional.ofNullable(bookRepo.findById(Long.valueOf(id)));

        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
//TODO dodanie daty i genre, potem autor i wydawnictwo
    @PostMapping("/books/add")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            Book _book = new Book();
            _book.setId(sequenceGenerator.generateSequence(Book.SEQUENCE_NAME));
            _book.setTitle(book.getTitle());
            _book.setDescription(book.getDescription());
            _book.setPremiereDate(book.getPremiereDate());
            _book.setAvailable(true);
            _book.setPrice(book.getPrice());
            bookRepo.save(_book);
            return new ResponseEntity<>(_book, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/books/{id}/update")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
        Optional<Book> bookData = Optional.ofNullable(bookRepo.findById(id));

        if (bookData.isPresent()) {
            Book _book = bookData.get();
            _book.setTitle(book.getTitle());
            _book.setDescription(book.getDescription());
            _book.setPrice(book.getPrice());
            return new ResponseEntity<>(bookRepo.save(_book), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/books/{id}/update/available")
    public ResponseEntity<Book> updateBookAvailable(@PathVariable("id") long id, @RequestBody Book book) {
        Optional<Book> bookData = Optional.ofNullable(bookRepo.findById(id));

        if (bookData.isPresent()) {
            Book _book = bookData.get();
            _book.setAvailable(false);
            return new ResponseEntity<>(bookRepo.save(_book), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") long id) {
        try {
            bookRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/books")
    public ResponseEntity<HttpStatus> deleteBooks() {
        try {
            bookRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}

