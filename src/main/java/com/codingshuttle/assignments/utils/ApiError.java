package com.codingshuttle.assignments.utils;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class ApiError {

    private String massage;

    private HttpStatus httpStatus;

    List<String> subErrors;


}
