package com.products.app.exceptions;

public class ProductSaverException extends RuntimeException{
    private final String details;
    private final String origin;

    public ProductSaverException(String origin,String details){
        super("An error ocurred when saving the product");
        this.origin = origin;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public String getOrigin() {
        return origin;
    }
}
