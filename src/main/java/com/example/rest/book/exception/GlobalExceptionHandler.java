package com.example.rest.book.exception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFound resourceNotFound, HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(System.currentTimeMillis(),
                404,
                "Not Found",
                resourceNotFound.getMessage(),
                request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception exception,HttpServletRequest request){

        ErrorResponse error=new ErrorResponse(System.currentTimeMillis(),
                500,
                "Internal Server Error",
                exception.getMessage(),
                request.getRequestURI());
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationError(MethodArgumentNotValidException exception,HttpServletRequest request){

        Map<String,String> error=new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach
                (err->error.put(err.getField(),err.getDefaultMessage()));

        return new  ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
