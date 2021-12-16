package com.products.domain.valueobjects;

import com.products.domain.exceptions.InvalidPriceException;

public class Price {

    private double value;

    public Price(double value){
        validate(value);
        this.value = value;
    }

    private void validate(double value){
        if(value < 0) throw new InvalidPriceException();
    }

    public double getValue() {
        return value;
    }
}
