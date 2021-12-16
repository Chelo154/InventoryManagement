package com.products.infra.spark.responses;

import com.products.app.exceptions.ProductGetterException;

public class ProductGetterErrorResponse {
    private String origin;
    private String details;

    public ProductGetterErrorResponse(ProductGetterException error){
        this.details = error.getDetails();
        this.origin = error.getOrigin();
    }

    public String getDetails() {
        return details;
    }

    public String getOrigin() {
        return origin;
    }
}
