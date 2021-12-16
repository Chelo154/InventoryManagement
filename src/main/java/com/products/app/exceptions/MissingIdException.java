package com.products.app.exceptions;

public class MissingIdException extends RuntimeException {

    public MissingIdException(){
        super("Missing id when finding a product");
    }


}
