package com.products.app.interfaces;

import com.products.app.dto.ProductDataDto;

public interface ProductFinder {
    public ProductDataDto findById(String id);
}
