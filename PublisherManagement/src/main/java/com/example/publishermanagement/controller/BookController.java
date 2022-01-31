package com.example.publishermanagement.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {


    @GetMapping("/hello-world")
    public String getHelloWorld(){
        return "hello world";
    }

    @GetMapping("/books/")
    public String getAllBooks(){
        return "get all books";
    }

    @GetMapping("/books/{bookId}/")
    public String getBook(@PathVariable Long bookId){
        return "getting the book with the id of " + bookId;
    }

    @PostMapping("/books/")
    public String createBook(@RequestBody String body){
        return "creating a book " + body;
    }

    @PutMapping("/books/{bookId}/")
    public String updateBook(@PathVariable(value = "bookId") Long bookId, @RequestBody String body){
        return "updating the book with the id of " + bookId + body;
    }

    @DeleteMapping("/books/{bookId}/")
    public String deleteBook(@PathVariable(value = "bookId") Long bookId){
        return "deleting the book with the id of " + bookId;

    }







}
