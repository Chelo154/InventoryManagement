package com.products.app.dto;

import com.products.domain.entities.Product;

import java.util.ArrayList;

public class ProductListResponseDto {
    public ArrayList<ProductInfoResponseDto> products;

    public ProductListResponseDto(ArrayList<Product> products){
        this.products = new ArrayList<>();

        products.forEach(product -> this.products.add(new ProductInfoResponseDto(
                product.getId(),
                product.getDescription(),
                product.getCost(),
                product.getProfit(),
                product.getSalesPrice()
        )));
    }

    public ArrayList<ProductInfoResponseDto> getProducts() {
        return products;
    }
}
