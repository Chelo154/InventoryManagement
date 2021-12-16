package com.products.app.service;

import com.products.app.dto.ProductInfoResponseDto;
import com.products.app.exceptions.ProductNotFoundException;
import com.products.app.interfaces.ProductFinder;
import com.products.domain.entities.Product;

public class ProductFinderService {
    private ProductFinder finder;

    public ProductFinderService(ProductFinder finder){
        this.finder = finder;
    }

    public ProductInfoResponseDto findById(String id){
        try{
            Product found  = finder.findById(id).map();

            return new ProductInfoResponseDto(
                    found.getId(),
                    found.getDescription(),
                    found.getCost(),
                    found.getProfit(),
                    found.getSalesPrice()
            );
        }catch (NullPointerException notFoundError){
            throw  new ProductNotFoundException(id);
        }
    }
}
