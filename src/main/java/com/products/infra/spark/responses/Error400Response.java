package com.products.infra.spark.responses;

public class Error400Response {
    private String type;
    private String message;

    public Error400Response(Exception exception){
        type = exception.getClass().getSimpleName();
        message = exception.getMessage();
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
