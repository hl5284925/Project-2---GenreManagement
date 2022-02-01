package com.example.publishermanagement.repository;

import com.example.publishermanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

  //Book findByBook_name(String book_name);

}
