package com.codingshuttle.assignments.advices;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ApiResponce<T> {


    private T data;
    private ApiError error;
    private LocalDateTime localDateTime;


    public ApiResponce() {
        this.localDateTime= LocalDateTime.now();
    }

    public ApiResponce(ApiError error) {
        this();
        this.error = error;
    }

    public ApiResponce(T data) {
        this();
        this.data = data;
    }
}
