package com.codingshuttle.assignments.exceptions;

import com.codingshuttle.assignments.utils.ApiError;
import com.codingshuttle.assignments.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptions {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<String> collect = exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError apiError = ApiError.builder().massage("Invalid Input").httpStatus(HttpStatus.BAD_REQUEST).subErrors(collect).build();
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> resourceNotFoundExceptionHandler(ResourceNotFoundException exception){
        ApiError apiError = ApiError
                .builder()
                .massage(exception.getMessage())
                .subErrors(null)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(new ApiResponse<>(apiError),HttpStatus.NOT_FOUND);

    }
}
