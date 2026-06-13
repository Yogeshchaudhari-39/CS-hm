package com.codingshuttle.assignments.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

                if(value!=null){
                 return value.matches("   \"^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@$%^&*]).{10}$\"");
                }
                return false;

    }
}
