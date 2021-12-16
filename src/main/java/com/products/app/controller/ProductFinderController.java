package com.products.app.controller;

import com.products.app.dto.ProductInfoResponseDto;
import com.products.app.exceptions.MissingIdException;
import com.products.app.service.ProductFinderService;

public class ProductFinderController {

    private ProductFinderService service;

    public ProductFinderController(ProductFinderService service){
        this.service = service;
    }

    public ProductInfoResponseDto findProductById(String id){
        if(id == null || id.isEmpty() ) throw new MissingIdException();

        return service.findById(id);
    }
}
