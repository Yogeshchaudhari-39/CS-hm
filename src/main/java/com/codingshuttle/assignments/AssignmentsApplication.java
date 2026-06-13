package com.codingshuttle.assignments;

import com.codingshuttle.assignments.models.CakeBaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AssignmentsApplication {

    @Autowired
    private CakeBaker cakeBaker;

    public static void main(String[] args) {
      ApplicationContext applicationContext = SpringApplication.run(AssignmentsApplication.class, args);
        CakeBaker cakeBaker1= (CakeBaker) applicationContext.getBean(CakeBaker.class);
        cakeBaker1.bakeCake();

    }

}
