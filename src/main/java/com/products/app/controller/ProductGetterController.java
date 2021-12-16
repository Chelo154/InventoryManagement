package com.products.app.controller;

import com.products.app.dto.ProductListResponseDto;
import com.products.app.service.ProductGetterService;

public class ProductGetterController {

    private ProductGetterService service;

    public ProductGetterController(ProductGetterService service){
        this.service = service;
    }

    public ProductListResponseDto getAllProducts(){
        return service.getAllProducts();
    }
}
