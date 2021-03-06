package com.example.publishermanagement.service;


import com.example.publishermanagement.exceptions.InformationExistException;
import com.example.publishermanagement.exceptions.InformationNotFoundException;
import com.example.publishermanagement.model.Book;
import com.example.publishermanagement.model.Genre;
import com.example.publishermanagement.model.Movie;
import com.example.publishermanagement.model.Song;
import com.example.publishermanagement.repository.BookRepository;
import com.example.publishermanagement.repository.GenreRepository;
import com.example.publishermanagement.repository.MovieRepository;
import com.example.publishermanagement.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GenreService {

    private GenreRepository genreRepository;
    private BookRepository bookRepository;
    private MovieRepository movieRepository;
    private SongRepository songRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }


    public Optional<Genre> getGenre(Long genreId) {
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }

    public Genre createGenre(Genre genreObject) {

        Genre genre = genreRepository.findByName(genreObject.getName());

        if (genre != null) {
            throw new InformationExistException("genre with name " + genre.getName() + " already exists");
        } else {
            return genreRepository.save(genreObject);
        }
    }

    public Genre updateGenre(Long genreId, Genre genreObject) {

        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre.isPresent()) {
            if (genreObject.getName().equals(genre.get().getName())) {
                throw new InformationExistException("genre " + genre.get().getName() + " already exists");
            } else {
                Genre updateGenre = genreRepository.findById(genreId).get();
                updateGenre.setName(genreObject.getName());
                return genreRepository.save(updateGenre);
            }
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }

    public Optional<Genre> deleteGenre(Long genreId) {
        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre.isPresent()) {
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

        if (genre.isEmpty()) {
            throw new InformationNotFoundException(
                    "genre with id " + genreId + " does not exist");
        }

        Optional<Book> book = bookRepository.findByName(bookObject.getName());
        if (book.isPresent()) {
            throw new InformationExistException("book with title " + bookObject.getName() + " already exists");
        } else {
            bookObject.setGenre(genre.get());
            return bookRepository.save(bookObject);
        }
    }

    public Book updateGenreBook(Long genreId, Long bookId, Book bookObject) {
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            for (Book book : genre.get().getBookList()) {
                if (book.getBook_id().equals(bookId)) {
                    book.setName(bookObject.getName());
                    book.setPublisher_name(bookObject.getPublisher_name());
                    book.setBook_year(bookObject.getBook_year());
                    return bookRepository.save(book);
                }
            }
            throw new InformationNotFoundException("book with id " + bookId + " does not exist");

        } else {
            throw new InformationNotFoundException("genre with Id " + genreId + " does not exist");
        }
    }

    public Book getGenreBook(Long genreId, Long bookId) {

        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre.isPresent()) {
            for (Book book : genre.get().getBookList()) {
                if (book.getBook_id().equals(bookId)) {
                    return bookRepository.save(book);
                }
            }
            throw new InformationNotFoundException("book with id " + bookId + " does not exist");
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " does not exist");
        }
    }

    public Book deleteGenreBook(Long genreId, Long bookId) {

        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            for (Book book : genre.get().getBookList()) {
                if (book.getBook_id().equals(bookId)) {
                    bookRepository.deleteById(book.getBook_id());
                    return book;
                }
            }
            throw new InformationNotFoundException("book with id " + bookId + " not found");
        } else {
            throw new InformationNotFoundException("genre with Id " + genreId + " not found");
        }
    }

    public List<Movie> getGenreMovies(Long genreId) {
        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre.isPresent()) {
            return genre.get().getMovieList();
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }

    }


    public Movie createGenreMovie(Long genreId, Movie movieObject) {

        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre.isEmpty()) {
            throw new InformationNotFoundException(
                    "genre with id " + genreId + " does not exist");
        }

        Optional<Movie> movie = movieRepository.findByName(movieObject.getName());
        if (movie.isPresent()) {
            throw new InformationExistException("movie with title " + movieObject.getName() + " already exists");
        } else {
            movieObject.setGenre(genre.get());
            return movieRepository.save(movieObject);
        }


    }


    public Movie getGenreMovie(Long genreId, Long movieId) {

        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre.isPresent()) {
            for (Movie movie : genre.get().getMovieList()) {
                if (movie.getId().equals(movieId)) {
                    return movieRepository.save(movie);
                }
            }
            throw new InformationNotFoundException("movie with id " + movieId + " does not exist");
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " does not exist");
        }
    }

    public Movie updateGenreMovie(Long genreId, Long movieId, Movie movieObject) {
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            for (Movie movie : genre.get().getMovieList()) {
                if (movie.getId().equals(movieId)) {
                    movie.setName(movieObject.getName());
                    movie.setYear(movieObject.getYear());
                    movie.setDirector(movieObject.getDirector());

                    return movieRepository.save(movie);
                }
            }
            throw new InformationNotFoundException("movie with id " + movieId + " does not exist");

        } else {
            throw new InformationNotFoundException("genre with Id " + genreId + " does not exist");
        }


    }

    public Movie deleteGenreMovie(Long genreId, Long movieId) {

        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            for (Movie movie : genre.get().getMovieList()) {
                if (movie.getId().equals(movieId)) {
                    movieRepository.deleteById(movie.getId());
                    return movie;
                }
            }
            throw new InformationNotFoundException("movie with id " + movieId + " not found");
        } else {
            throw new InformationNotFoundException("genre with Id " + genreId + " not found");
        }

    }


    public List<Song> getGenreSongs(Long genreId) {

        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre.isPresent()) {
            return genre.get().getSongList();
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }


    public Song createGenreSong(Long genreId, Song songObject) {

        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre.isEmpty()) {
            throw new InformationNotFoundException(
                    "genre with id " + genreId + " does not exist");
        }

        Optional<Song> song = songRepository.findByName(songObject.getName());
        if (song.isPresent()) {
            throw new InformationExistException("song with title " + songObject.getName() + " already exists");
        } else {
            songObject.setGenre(genre.get());
            return songRepository.save(songObject);
        }
    }

    public Song getGenreSong(Long genreId, Long songId) {

        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genre.isPresent()) {
            for (Song song : genre.get().getSongList()) {
                if (song.getId().equals(songId)) {
                    return songRepository.save(song);
                }
            }
            throw new InformationNotFoundException("song with id " + songId + " does not exist");
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " does not exist");
        }

    }


    public Song updateGenreSong(Long genreId, Long songId, Song songObject) {

        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            for (Song song : genre.get().getSongList()) {
                if (song.getId().equals(songId)) {
                    song.setName(songObject.getName());
                    song.setYear(songObject.getYear());
                    song.setLanguage(songObject.getLanguage());
                    return songRepository.save(song);
                }
            }
            throw new InformationNotFoundException("song with id " + songId + " does not exist");

        } else {
            throw new InformationNotFoundException("genre with Id " + genreId + " does not exist");
        }
    }


    public Song deleteGenreSong(Long genreId, Long songId) {

        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            for (Song song : genre.get().getSongList()) {
                if (song.getId().equals(songId)) {
                    songRepository.deleteById(song.getId());
                    return song;
                }
            }
            throw new InformationNotFoundException("song with id " + songId + " not found");
        } else {
            throw new InformationNotFoundException("genre with Id " + genreId + " not found");
        }

    }
}
