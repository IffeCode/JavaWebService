package org.example.javalibrarywithjwt.service;

import jakarta.transaction.Transactional;
import org.example.javalibrarywithjwt.model.Author;
import org.example.javalibrarywithjwt.repository.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //Listar alla författare
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Author with id " + id + " not found!"
                        ));
    }

    //skapa ny författare
    public Author create(Author author) {
        author.setId(null);
        return authorRepository.save(author);
    }

    //uppdaterar en befintlig författare
    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = findById(id);

        existingAuthor.setFirstName(author.getFirstName());
        existingAuthor.setLastName(author.getLastName());

        return authorRepository.save(existingAuthor);
    }

    //Radera en författare
    public void deleteAuthor(Long id) {
        authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Author not found with id: " + id
                ));

        authorRepository.deleteById(id);
    }


}
