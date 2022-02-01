package com.example.publishermanagement.controller;

import com.example.publishermanagement.exceptions.InformationExistException;
import com.example.publishermanagement.exceptions.InformationNotFoundException;
import com.example.publishermanagement.model.Genre;

import com.example.publishermanagement.repository.GenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GenreController {


    @Autowired
    private GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/hello-world/")
    public String getHelloWorld(){

        return "hello world";
    }


    @GetMapping("/genres/")
    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

//
//    @GetMapping("/genres/{genreId}/")
//    public Optional getGenre(@PathVariable Long genreId) throws Exception {
//
//
//        Optional genre = genreRepository.findById(genreId);
//
//        if (genre.isPresent()) {
//            return genre;
//        } else {
//            throw new Exception("genre with id " + genreId + " not found");
//        }
//    }
//
    @PostMapping("/genres/")
    public Genre createGenre(@RequestBody Genre genreObject){

        Genre genre = genreRepository.findByName(genreObject.getname());
        if(genre != null){
            throw new InformationExistException("genre with name " + genre.getname() + " already exists");
        }else {
            return genreRepository.save(genreObject);

        }

    }

    @PutMapping("/genres/{genreId}/")
    public Genre updateGenre(@PathVariable(value = "genreId") Long genreId, @RequestBody Genre genreObject){
        Optional<Genre> genre = genreRepository.findById(genreId);

        if(genre.isPresent()){
            if(genreObject.getname().equals(genre.get().getname())){
                throw new InformationExistException("genre " + genre.get().getname() + " already exists");

            }else {
                Genre updateGenre = genreRepository.findById(genreId).get();
                updateGenre.setname(genreObject.getname());

                return genreRepository.save(updateGenre);
            }

        }else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }

    }

    @DeleteMapping("/genres/{genreId}/")
    public Optional<Genre> deleteGenre(@PathVariable(value = "genreId") Long genreId){
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            genreRepository.deleteById(genreId);
            return genre;
        }else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }

    }
}
