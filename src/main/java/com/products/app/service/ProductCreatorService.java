package com.products.app.service;

import com.products.app.dto.ProductCreatorDto;
import com.products.app.dto.ProductDataDto;
import com.products.app.dto.ProductInfoResponseDto;
import com.products.app.interfaces.IdGenerator;
import com.products.app.interfaces.ProductSaver;
import com.products.domain.entities.Product;

public class ProductCreatorService {
    private final IdGenerator idGenerator;
    private final ProductSaver productSaver;


    public ProductCreatorService(IdGenerator idGenerator, ProductSaver productSaver){
        this.idGenerator = idGenerator;
        this.productSaver = productSaver;
    }

    public ProductInfoResponseDto createProduct(ProductCreatorDto dto){
        Product product = new Product(
                idGenerator.generateId(),
                dto.getDescription(),
                dto.getCost(),
                dto.getProfit()
        );

        productSaver.save(new ProductDataDto(
                product.getId(),
                product.getDescription(),
                product.getCost(),
                product.getProfit()
        ));

        return new ProductInfoResponseDto(
                product.getId(),
                product.getDescription(),
                product.getCost(),
                product.getProfit(),
                product.getSalesPrice()
        );
    }
}
