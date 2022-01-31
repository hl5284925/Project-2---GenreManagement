package com.example.publishermanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



public class InformationNotFoundException extends RuntimeException{

    public InformationNotFoundException(String message){
        super(message);
    }}
