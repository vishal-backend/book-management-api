package com.example.rest.book.exception;

public class ResourceNotFound extends RuntimeException{

    public  ResourceNotFound(String message){
        super(message);
    }
}
