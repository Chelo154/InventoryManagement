package com.products.expecteds;

import com.products.app.dto.ProductDataDto;
import com.products.app.dto.ProductListResponseDto;
import com.products.domain.entities.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductGetterExpecteds {

    public static final ProductDataDto[] DATA_EXPECTEDS = new ProductDataDto[]{
            new ProductDataDto(
                    "abc123",
                    "Batman: The three jokers",
                    100,
                    20
            ),
            new ProductDataDto(
                    "def456",
                    "Batman: The Killing Joke",
                    200,
                    10
            )
    };

    public static final ProductListResponseDto EXPECTED_LIST = new ProductListResponseDto(new ArrayList<>(Arrays.asList(
            new Product(
                    "abc123",
                    "Batman: The three jokers",
                    100,
                    20
            ),
            new Product(
                    "def456",
                    "Batman: The Killing Joke",
                    200,
                    10
            ))));
}
