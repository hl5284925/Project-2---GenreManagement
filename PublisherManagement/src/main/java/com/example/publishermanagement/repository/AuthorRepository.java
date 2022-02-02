package com.example.publishermanagement.repository;


import com.example.publishermanagement.model.AuthorPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorPage,Long> {

 //   Author findByAuthor_name(String author_name);


}
