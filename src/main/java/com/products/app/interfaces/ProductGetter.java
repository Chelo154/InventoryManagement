package com.products.app.interfaces;

import com.products.app.dto.ProductDataDto;

import java.util.ArrayList;

public interface ProductGetter {
    public ArrayList<ProductDataDto> getProducts();
}
