package com.codingshuttle.assignments.models.impl;

import com.codingshuttle.assignments.models.Frosting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("strawberryFrost")
public class SrawberryFrosting implements Frosting {
    @Override
    public void getFrostingType() {
        System.out.println("baking cake with Strawberry frosting");
    }
}
