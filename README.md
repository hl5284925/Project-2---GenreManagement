# Project-2 -GenreManagement



## Description

 This application is basically for users to check information about genres such as books, movies, and songs. It will perform public CRUD operations. Future version will add more features of genres and will also allow users to register and log in.



## Entity Relationship Diagram(ERD):
<img src ="https://user-images.githubusercontent.com/89958717/152399747-f98a047c-6789-4518-a235-edd7676c8c3d.png" width = "700" height = "800" />



## POM Dependencies
```ruby
<dependencies>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
    </dependencies>
```




## Endpoints
<img src="https://user-images.githubusercontent.com/89958717/152418501-d6f528d0-17d2-4189-997e-76ff23538794.png" width = "400" height ="400" />




Endpoint	| Functionality	|Access
--- | --- | ---
GET */api/genres/*	|Get all genres |	Public
POST */api/genres/*	|Create one genre|	Public
GET */api/genres/genreId/*	|Get one genre|	Public
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
GET */api/genres/genreId/songs/songId/*	|Get one song	|Public
PUT */api/genres/genreId/songs/songId/*	|Update one song	|Public
DELETE */api/genres/genreId/songs/songId/*	|Delete one song	|Public


## Machineries Used


<img src="https://user-images.githubusercontent.com/89958717/152427948-80646147-4d15-4570-8339-806bc1becf95.png" width = "500" height="150" /> <img src="https://user-images.githubusercontent.com/89958717/152431701-b5f8aca0-64e4-445d-82bd-a6ac18eb55fb.png" width = "500" height="150" /> <img src="https://user-images.githubusercontent.com/89958717/152430541-87b557b6-125d-4714-af33-76f25969f349.png" width = "500" height="200" /> <img src="https://user-images.githubusercontent.com/89958717/152430854-3eab77d1-6e87-466d-b0cd-6eb32a63c87f.png" width = "500" height="150" /> <img src="https://user-images.githubusercontent.com/89958717/152438985-672f169a-d21a-42c5-b375-a326b18ac547.png" width = "500" height="150" /> <img src="https://user-images.githubusercontent.com/89958717/152439217-a94ed71d-f6b2-4b9f-a78f-9ab89daa876b.png" width = "400" height="150" />




## User Stories
<img src="https://user-images.githubusercontent.com/89958717/152399362-99d7596a-fe4f-4d3e-841f-e62bd37b1e67.png" width = "800" height="400"/>

|      |
|--- |
|1. As a user, I would like to view a list of all the genres.|
|2. As a user, I would like to create one genre.|
|3. As a user, I would like to get one genre.|
|4. As a user, I would like to update one genre.|
|5. As a user, I would like to delete one genre. |
|6. As a user, I would like to view a list of all the books.|
|7. As a user, I would like to create one book.|
|8. As a user, I would like to get one book.|
|9. As a user, I would like to update one book.|
|10. As a user, I would like to delete one book. |
|11. As a user, I would like to view a list of all the movies.|
|12. As a user, I would like to create one movie.|
|13. As a user, I would like to get one movie.|
|14. As a user, I would like to update one movie.|
|15. As a user, I would like to delete one movie. |
|16. As a user, I would like to view a list of all the songs.|
|17. As a user, I would like to create one song.|
|18. As a user, I would like to get one song.|
|19. As a user, I would like to update one song.|
|20. As a user, I would like to delete one song.|


## Project Challenges
1. I did not have a clear mind about the application purpose, and not sure about what I wanted the application to look like. After some brainstorming, research and discussion, I finally decided to start with basic version instead of having a big picture in mind but don't know where to start.
2. I wanted to create ManytoMany relationship in JPA, did some effort but still did not make it work, so finally gave up this feature in the project, hope I could make it work in future versions.

## Special Thanks 🤗😊�
- Dhrubo: helped me to brainstorm and think what is my application purpose.
- Julio: gave me advice and ideas about the application features, helped me debug and explain to me whenever I needed any support.


