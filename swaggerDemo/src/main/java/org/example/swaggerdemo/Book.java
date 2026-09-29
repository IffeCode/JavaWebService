package org.example.swaggerdemo;

public class Book {

    private int id;
    private String titel;
    private String author;

    public Book() {
        this.id = 0;
        this.titel = "";
        this.author = "";
    }

    public Book(int id, String titel, String author) {
        this.id = id;
        this.titel = titel;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
