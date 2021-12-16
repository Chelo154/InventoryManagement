package com.products.app.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id){
        super(String.format("Product not found for id %s",id));
    }
}
