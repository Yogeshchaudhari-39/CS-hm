package com.codingshuttle.assignments.models.impl;

import com.codingshuttle.assignments.models.Syrup;
import org.springframework.stereotype.Component;

@Component
public class StrawberrySyrup implements Syrup {
    @Override
    public void getSyrupType() {
        System.out.println("baking cake with Strawberry Syrup");
    }
}
