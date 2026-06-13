package com.codingshuttle.assignments.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumber,Integer> {


    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if (value <= 1) {
            return false;
        }

        // Check every number from 2 up to (value - 1)
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }
}
