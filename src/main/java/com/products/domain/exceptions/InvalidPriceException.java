package com.products.domain.exceptions;

public class InvalidPriceException extends RuntimeException{

    public InvalidPriceException(){
        super("Price must be higher or equal to 0");
    }
}
