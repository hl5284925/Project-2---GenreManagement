package com.example.publishermanagement.controller;


import com.example.publishermanagement.model.Book;
import com.example.publishermanagement.model.Genre;

import com.example.publishermanagement.model.Movie;
import com.example.publishermanagement.repository.GenreRepository;

import com.example.publishermanagement.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GenreController {


    @Autowired
    private GenreService genreService;

    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @Autowired
    private GenreRepository genreRepository;

    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @GetMapping("/hello-world/")
    public String getHelloWorld() {
        return "hello world";
    }


    @GetMapping("/genres/")
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }


    @GetMapping("/genres/{genreId}/")
    public Optional getGenre(@PathVariable Long genreId) throws Exception {

        Optional genre = genreService.getGenre(genreId);

        if (genre.isPresent()) {
            return genre;
        } else {
            throw new Exception("genre with id " + genreId + " not found");
        }
    }

    @PostMapping("/genres/")
    public Genre createGenre(@RequestBody Genre genreObject) {

        return genreService.createGenre(genreObject);

    }

    @PutMapping("/genres/{genreId}/")
    public Genre updateGenre(@PathVariable(value = "genreId") Long genreId, @RequestBody Genre genreObject) {

        return genreService.updateGenre(genreId, genreObject);

    }

    @DeleteMapping("/genres/{genreId}/")
    public Optional<Genre> deleteGenre(@PathVariable(value = "genreId") Long genreId) {

        return genreService.deleteGenre(genreId);
    }


    @GetMapping("/genres/{genreId}/books/")
    public List<Book> getGenreBooks(@PathVariable(value = "genreId") Long genreId) {
        return genreService.getGenreBooks(genreId);
    }

    @PostMapping("/genres/{genreId}/books")
    public Book createGenreBook(
            @PathVariable(value = "genreId") Long genreId,
            @RequestBody Book bookObject) {
        return genreService.createGenreBook(genreId, bookObject);
    }


    @GetMapping("/genres/{genreId}/books/{bookId}")
    public Book getGenreBook(
            @PathVariable(value = "genreId") Long genreId,
            @PathVariable(value = "bookId") Long bookId) {
        return genreService.getGenreBook(genreId, bookId);
    }

//    @PutMapping("/genres/{genreId}/books/{bookId}")
//    public Book updateGenreBook(
//            @PathVariable(value = "genreId") Long genreId,
//            @PathVariable(value = "bookId") Long bookId,
//            @RequestBody Book bookObject) {
//        return genreService.updateGenreBook(genreId, bookId, bookObject);
//    }
//
//    @DeleteMapping("/genres/{genreId}/books/{bookId}")
//
//    public Book deleteGenreBook(
//            @PathVariable(value = "genreId") Long genreId,
//            @PathVariable(value = "bookId") Long bookId) {
//        return genreService.deleteGenreBook(genreId, bookId);
//
//    }
//
//
//
//    @GetMapping("/genres/{genreId}/movies/")
//
//    public List<Movie> getGenreMovies(@PathVariable(value = "genreId") Long genreId) {
//        return genreService.getGenreMovies(genreId);
//    }
//
//
//
//    @PostMapping("/genres/{genreId}/movies/")
//
//    public Movie createGenreMovie(
//            @PathVariable(value = "genreId") Long genreId,
//            @RequestBody Movie movieObject){
//        return genreService.createGenreMovie(genreId,movieObject);
//
//    }
//
//
//    @GetMapping("/genres/{genreId}/movies/{movieId}/")
//
//    public Movie getGenreMovie(
//            @PathVariable(value = "genreId") Long genreId,
//            @PathVariable(value = "movieId") Long movieId){
//        return genreService.getGenreMovie(genreId, movieId);
//    }
//
//
//    @PutMapping("/genres/{genreId}/movies/{movieId}/")
//
//    public Movie updateGenreMovie(
//            @PathVariable(value = "genreId") Long genreId,
//            @PathVariable(value = "movieId") Long movieId,
//            @RequestBody Movie movieObject){
//        return genreService.updateGenreMovie(genreId, movieId, movieObject);
//    }
//
//
//    @DeleteMapping("/genres/{genreId}/movies/{movieId}/")
//
//    public Movie deleteGenreMovie(
//            @PathVariable(value = "genreId") Long genreId,
//            @PathVariable(value = "movieId") Long movieId){
//        return genreService.deleteGenreMovie(genreId, movieId);
//
//    }
//
















}
