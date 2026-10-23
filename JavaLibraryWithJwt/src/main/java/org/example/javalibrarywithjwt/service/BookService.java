package org.example.javalibrarywithjwt.service;

import jakarta.transaction.Transactional;
import org.example.javalibrarywithjwt.model.Book;
import org.example.javalibrarywithjwt.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Listar alla böcker
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    //Hämtar böcker baserat på id
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Book with id " + id + " not found."
                        ));
    }



}
