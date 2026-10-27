package org.example.javalibrarywithjwt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "book:id", nullable = false)
    private Book book;

    @NotNull
    @Column(nullable = false)
    private LocalDate loanDate;

    @NotNull
    @Column(nullable = false)
    private LocalDate dueDate;

    private LocalDate returnDate;

    public Loan() {
    }
}
