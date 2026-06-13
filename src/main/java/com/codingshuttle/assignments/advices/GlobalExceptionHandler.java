package com.codingshuttle.assignments.advices;

import com.codingshuttle.assignments.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handlerResourceNotFound(ResourceNotFoundException exception) {
        ApiError apiError =ApiError
                .builder().
                massage(exception.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponce<?>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){

        List<String> collect = exception.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());

        ApiError error= ApiError.builder().massage("Invalid Input").subErrors(collect).httpStatus(HttpStatus.BAD_REQUEST).build();
        ApiResponce<ApiError> objectApiResponce = new ApiResponce<>(error);

        return new ResponseEntity<>(objectApiResponce,HttpStatus.BAD_REQUEST);


    }
}
