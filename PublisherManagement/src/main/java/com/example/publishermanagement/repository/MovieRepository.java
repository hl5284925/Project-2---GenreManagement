package com.example.publishermanagement.repository;

import com.example.publishermanagement.model.Book;
import com.example.publishermanagement.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Optional<Movie> findByName(String name);



}
