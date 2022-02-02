package com.example.publishermanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long book_id;

    @Column
    private String book_title;

    @Column
    private String author_name;

    @Column
    private Long genre_id;

    @Column
    private String publisher_name;



    @Column
    private String book_year;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;


    public Book() {
    }

    public Book(Long book_id, String book_title, String author_name, Long genre_id, String publisher_name, String book_year) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.author_name = author_name;
        this.genre_id = genre_id;
        this.publisher_name = publisher_name;
        this.book_year = book_year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_title='" + book_title + '\'' +
                ", author_name='" + author_name + '\'' +
                ", genre_id='" + genre_id + '\'' +
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

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
