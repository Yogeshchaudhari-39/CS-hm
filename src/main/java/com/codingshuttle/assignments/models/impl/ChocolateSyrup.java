package com.codingshuttle.assignments.models.impl;

import com.codingshuttle.assignments.models.Syrup;
import org.springframework.stereotype.Component;

@Component
public class ChocolateSyrup implements Syrup {


    @Override
    public void getSyrupType() {
        System.out.println("baking cake with chocolate Syrup");
    }
}
