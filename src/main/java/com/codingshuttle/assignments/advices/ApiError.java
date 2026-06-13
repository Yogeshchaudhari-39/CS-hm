package com.codingshuttle.assignments.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@Builder
public class ApiError {

    private HttpStatus httpStatus;
    private String massage;
    private List<String> subErrors;
}
