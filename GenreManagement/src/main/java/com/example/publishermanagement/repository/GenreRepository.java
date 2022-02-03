package com.example.publishermanagement.repository;


import com.example.publishermanagement.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;



public interface GenreRepository extends JpaRepository<Genre,Long> {

    Genre findByName(String genre_name);


}
