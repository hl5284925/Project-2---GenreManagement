package com.example.publishermanagement.model;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long book_id;

    @Column
    private String book_name;

    @Column
    private String author_name;

    @Column
    private String genre_name;

    @Column
    private String publisher_name;

    @Column
    private String book_year;

    public Book() {
    }

    public Book(Long book_id, String book_name, String author_name, String genre_name, String publisher_name, String book_year) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author_name = author_name;
        this.genre_name = genre_name;
        this.publisher_name = publisher_name;
        this.book_year = book_year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", author_name='" + author_name + '\'' +
                ", genre_name='" + genre_name + '\'' +
                ", publisher_name='" + publisher_name + '\'' +
                ", book_year='" + book_year + '\'' +
                '}';
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getBook_year() {
        return book_year;
    }

    public void setBook_year(String book_year) {
        this.book_year = book_year;
    }
}
