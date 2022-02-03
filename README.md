# Project-2---GenreManagement





## ERD Diagram (ERD):










## Endpoints

| Endpoint      | Functionality | Access|
| ------------- |:-------------:| -----:|
| GET           | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |


Endpoint	| Functionality	|Access
--- | --- | ---
GET */api/genres/*	|Get all genres |	Public
POST */api/genres/*	|Create one genre|	Public
PUT */api/genres/genreId/*	|Update one genre |	Public
DELETE */api/genres/genreId/*	|Delete one genre|	Public

GET */api/genres/genreId/books/*	|Get all books |	Public
CREATE */api/genres/genreId/books/*	|Create one book	|Public
GET */api/genres/genreId/books/bookId/*	|Get one book |	Public
PUT */api/genres/genreId/books/bookId/*	|Update one book|	Public
DELETE */api/genres/genreId/books/bookId/*	|Delete one book	|Public

GET */api/genres/genreId/movies/*	|Get all movies	|Public
CREATE */api/genres/genreId/movies/*	|Create one movie	|Public
GET */api/genres/genreId/movies/movieId/*|	Get one movie	|Public
PUT */api/genres/genreId/movies/movieId/*	|Update one movie	|Public
DELETE */api/genres/genreId/movies/movieId/*	|Delete one movie	|Public

GET */api/genres/genreId/songs/*	|Get all songs|	Public
CREATE */api/genres/genreId/songs/*	|Create one song|	Public
GET */api/genres/genreId/movies/songId/*	|Get one song	|Public
PUT */api/genres/genreId/movies/songId/*	|Update one song	|Public
DELETE */api/genres/genreId/movies/movieId/*	|Delete one movie	|Public


