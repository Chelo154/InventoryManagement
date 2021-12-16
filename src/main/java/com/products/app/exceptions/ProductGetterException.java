package com.products.app.exceptions;

public class ProductGetterException extends RuntimeException {
    private final String details;
    private final String origin;

    public ProductGetterException(String details, String origin){
        this.details = details;
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDetails() {
        return details;
    }
}
