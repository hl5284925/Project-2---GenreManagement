package com.example.publishermanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long book_id;

    @Column
    private String name;


    @Column
    private String publisher_name;


    @Column
    private String book_year;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = @JoinColumn(name = "author_id"))

    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

//    public List<Author> addAuthor(Author author){
//        if(authors == null){
//            authors = new ArrayList<>();
//            authors.add(author);
//            return authors;
//        }
//
//    }





    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Book() {
    }

    public Book(Long book_id, String name, String publisher_name, String book_year) {
        this.book_id = book_id;
        this.name = name;
        this.publisher_name = publisher_name;
        this.book_year = book_year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
