package com.products.app.service;

import com.products.app.dto.ProductDataDto;
import com.products.app.dto.ProductListResponseDto;
import com.products.app.interfaces.ProductGetter;
import com.products.domain.entities.Product;

import java.util.ArrayList;

public class ProductGetterService {
    private ProductGetter getter;

    public ProductGetterService(ProductGetter getter){
        this.getter = getter;
    }

    public ProductListResponseDto getAllProducts(){
        ArrayList<ProductDataDto> productData = getter.getProducts();

        ArrayList<Product> products = new ArrayList<>();

        productData.forEach(item -> products.add(item.map()));

        return new ProductListResponseDto(products);
    }
}
