package org.example.javalibrarywithjwt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty!")
    @Size(min = 5, max = 200, message = "Title cannot be below 5 characters and cannot exceed 200 characters!")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Description cannot be empty!")
    @Size(min = 10, max = 200, message = "Description cannot be below 10 characters and cannot exceed 200 characters!")
    @Column(nullable = false)
    private String description;

    //Kopplar författare till flera böcker
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(Long id, String title, String description, Author author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
    }
}
