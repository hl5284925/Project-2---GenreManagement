package com.example.publishermanagement.repository;

import com.example.publishermanagement.exceptions.InformationExistException;
import com.example.publishermanagement.exceptions.InformationNotFoundException;
import com.example.publishermanagement.model.Book;
import com.example.publishermanagement.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre,Long> {

    Genre findByGenre_name(String genre_name);

}
