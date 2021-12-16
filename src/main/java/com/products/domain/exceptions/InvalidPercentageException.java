package com.products.domain.exceptions;

public class InvalidPercentageException extends RuntimeException {
    public InvalidPercentageException(double value){
        super(String.format("%.2f is not a valid percentage",value));
    }
}
