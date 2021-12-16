package com.products.app.controller;

import com.products.app.dto.ProductCreatorDto;
import com.products.app.exceptions.InvalidDtoException;
import com.products.app.dto.ProductInfoResponseDto;
import com.products.app.service.ProductCreatorService;

public class ProductCreatorController {
    private final ProductCreatorService service;

    public ProductCreatorController(ProductCreatorService service){
        this.service = service;
    }


    public ProductInfoResponseDto createProduct(ProductCreatorDto dto){
        if(!dto.isValid()) throw new InvalidDtoException(dto.getClass().getSimpleName());

        return service.createProduct(dto);
    }
}
