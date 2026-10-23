package org.example.javalibrarywithjwt.controller;

import org.example.javalibrarywithjwt.model.Book;
import org.example.javalibrarywithjwt.repository.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Hämtar alla böcker
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
