package com.products.domain.valueobjects;

import com.products.domain.exceptions.InvalidPercentageException;

public class Percentage {
    private double value;

    public Percentage(double value){
        validate(value);

        this.value = value;
    }

    public double getValue() {
        return value;
    }

    private void validate(double value){
        if(value < 0) throw new InvalidPercentageException(value);
    }

    public double calculatePercentage(double amount){
        return amount * value / 100;
    }
}
