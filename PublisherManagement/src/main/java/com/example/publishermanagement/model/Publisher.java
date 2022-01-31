package com.example.publishermanagement.model;


import javax.persistence.*;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long publisher_id;

    @Column
    private String publisher_name;


    public Publisher() {
    }

    public Publisher(Long publisher_id, String publisher_name) {
        this.publisher_id = publisher_id;
        this.publisher_name = publisher_name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisher_id=" + publisher_id +
                ", publisher_name='" + publisher_name + '\'' +
                '}';
    }

    public Long getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Long publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }
}
