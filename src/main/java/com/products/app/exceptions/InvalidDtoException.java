package com.products.app.exceptions;

public class InvalidDtoException extends RuntimeException{
    public InvalidDtoException(String dtoName){
        super(String.format("%s is not valid, please send a valid %s",dtoName,dtoName));
    }
}
