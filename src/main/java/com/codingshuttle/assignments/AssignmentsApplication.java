package com.codingshuttle.assignments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AssignmentsApplication {

    public static void main(String[] args) {
      ApplicationContext applicationContext = SpringApplication.run(AssignmentsApplication.class, args);
    }

}
