package com.example.publishermanagement.repository;

import com.example.publishermanagement.model.Movie;
import com.example.publishermanagement.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository<Music,Long> {

    Optional<Music> findByName(String name);


}
