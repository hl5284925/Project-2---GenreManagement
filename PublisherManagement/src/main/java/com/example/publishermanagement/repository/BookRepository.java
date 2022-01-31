package com.example.publishermanagement.repository;

import com.example.publishermanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

    Book findBy(String book_name);
}
