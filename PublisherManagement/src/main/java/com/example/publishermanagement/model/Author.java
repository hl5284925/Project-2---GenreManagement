package com.example.publishermanagement.model;


import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long author_id;

    @Column
    private String author_name;

    @Column
    private String genre_name;


    public Author() {
    }

    public Author(Long author_id, String author_name, String genre_name) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.genre_name = genre_name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                ", genre_name='" + genre_name + '\'' +
                '}';
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
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
}
