package com.example.publishermanagement.model;

import javax.persistence.*;


@Entity
@Table(name = "genres")

public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long genre_id;

    @Column
    private String genre_name;

    @Column
    private String genre_description;


    public Genre() {
    }

    public Genre(Long genre_id, String genre_name, String genre_description) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
        this.genre_description = genre_description;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre_id=" + genre_id +
                ", genre_name='" + genre_name + '\'' +
                ", genre_description='" + genre_description + '\'' +
                '}';
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public String getGenre_description() {
        return genre_description;
    }

    public void setGenre_description(String genre_description) {
        this.genre_description = genre_description;
    }
}
