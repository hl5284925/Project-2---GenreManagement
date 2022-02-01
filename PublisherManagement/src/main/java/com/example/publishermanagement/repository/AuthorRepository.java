package com.example.publishermanagement.repository;


import com.example.publishermanagement.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

 //   Author findByAuthor_name(String author_name);


}
