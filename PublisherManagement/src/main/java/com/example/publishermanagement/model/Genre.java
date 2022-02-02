package com.example.publishermanagement.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "genres")

public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long genre_id;

    @Column
    private String name;



    @OneToMany(mappedBy = "genre", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Book> bookList;


    @OneToMany(mappedBy = "genre", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Movie> movieList;




    public Genre() {
    }

    public Genre(Long genre_id, String name) {
        this.genre_id = genre_id;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre_id=" + genre_id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }


}
