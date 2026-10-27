package org.example.javalibrarywithjwt.model;


import jakarta.validation.constraints.NotNull;

public class BorrowRequest {

    @NotNull(message = "Book ID cannot be empty!")
    private Long bookId;

}
