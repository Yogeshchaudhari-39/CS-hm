package com.codingshuttle.assignments.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ModelMapperBean {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


}
