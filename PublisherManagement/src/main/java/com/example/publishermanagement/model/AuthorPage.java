package com.example.publishermanagement.model;


import javax.persistence.*;

@Entity
@Table(name = "authorPages")
public class AuthorPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long author_id;

    @Column
    private String author_name;

    @Column
    private String author_country;


    public AuthorPage() {
    }

    public AuthorPage(Long author_id, String author_name, String author_country) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_country = author_country;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                ", author_country='" + author_country + '\'' +
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

    public String getAuthor_country() {
        return author_country;
    }

    public void setAuthor_country(String author_country) {
        this.author_country = author_country;
    }
}
