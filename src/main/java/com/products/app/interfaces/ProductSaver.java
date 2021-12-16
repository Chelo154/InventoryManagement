package com.products.app.interfaces;

import com.products.app.dto.ProductDataDto;
import com.products.domain.entities.Product;

public interface ProductSaver {
    public void save(ProductDataDto dto);
}
