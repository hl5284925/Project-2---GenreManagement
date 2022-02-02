package com.example.publishermanagement.service;


import com.example.publishermanagement.exceptions.InformationExistException;
import com.example.publishermanagement.exceptions.InformationNotFoundException;
import com.example.publishermanagement.model.Book;
import com.example.publishermanagement.model.Genre;
import com.example.publishermanagement.repository.BookRepository;
import com.example.publishermanagement.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private GenreRepository genreRepository;
    private BookRepository bookRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }


    public Optional getGenre(Long genreId) {
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }

    public Genre createGenre(Genre genreObject) {

        Genre genre = genreRepository.findByGenre_name(genreObject.getGenre_name());

        if (genre != null) {
            throw new InformationExistException("genre with name " + genre.getGenre_name() + " already exists");
        } else {
            return genreRepository.save(genreObject);
        }
    }

    public Genre updateGenre(Long genreId, Genre genreObject) {
        System.out.println("service calling updateGenre ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            if (genreObject.getGenre_name().equals(genre.get().getGenre_name())) {

                throw new InformationExistException("genre " + genre.get().getGenre_name() + " is already exists");
            } else {
                Genre updateGenre = genreRepository.findById(genreId).get();
                updateGenre.setGenre_name(genreObject.getGenre_name());

                return genreRepository.save(updateGenre);
            }
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }

    public Optional<Genre> deleteGenre(Long genreId) {
        Optional<Genre> genre = genreRepository.findById(genreId);

        if (((Optional<?>) genre).isPresent()) {
            genreRepository.deleteById(genreId);
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }

    }


    public List<Book> getGenreBooks(Long genreId) {

        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre.isPresent()) {
            return genre.get().getBookList();
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }


    public Book createGenreBook(Long genreId, Book bookObject) {

        Optional<Genre> genre = genreRepository.findById(genreId);

        if(genre.isEmpty()){
            throw new InformationNotFoundException(
                    "genre with id " + genreId + " does not exist");
        }

        Book book = bookRepository.findByBook_name(bookObject.getBook_title());
        if(book != null){
            throw new InformationExistException("book with name " + book.getBook_title() + " already exists");
        }else {
            bookObject.setGenre(genre.get());
            return bookRepository.save(bookObject);
        }

    }

    public Book updateGenreBook(Long genreId, Long bookId, Book bookObject) {
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            for(Book book : genre.get().getBookList()){
                if(book.getBook_id().equals(bookId)){
                    book.setBook_title(bookObject.getBook_title());
                    book.setAuthor_name(bookObject.getAuthor_name());
                    book.setGenre_id(bookObject.getGenre_id());
                    book.setPublisher_name(bookObject.getPublisher_name());
                    book.setBook_year(bookObject.getBook_year());
                    return bookRepository.save(book);
                }
            }
            throw new InformationNotFoundException("book with id " + bookId + " book does not exist");

        }else {
            throw new InformationNotFoundException("genre with Id " + genreId + " genre does not exist");
        }

    }

    public Book getGenreBook(Long genreId, Long bookId) {

        Optional<Genre> genre = genreRepository.findById(genreId);

        if(genre.isPresent()){
            for(Book book : genre.get().getBookList()){
                if(book.getBook_id().equals(bookId)){
                    return bookRepository.save(book);
                }
            } throw new InformationNotFoundException("book with id " + bookId + " does not exist");
        }else {
            throw new InformationNotFoundException("genre with id " + genreId + " does not exist");
        }

    }

    public Book deleteGenreBook(Long genreId, Long bookId) {

        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            for (Book book : genre.get().getBookList()) {
                if (book.getBook_id().equals(bookId)) {
                    bookRepository.deleteById(book.getBook_id());
                }
            }
            throw new InformationNotFoundException("book with id " + bookId + " does not exist");
        } else {
            throw new InformationNotFoundException("genre with Id " + genreId + " does not exist");

        }


    }
}
