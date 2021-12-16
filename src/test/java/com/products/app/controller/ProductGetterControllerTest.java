package com.products.app.controller;

import com.products.app.dto.ProductListResponseDto;
import com.products.app.service.ProductGetterService;
import com.products.expecteds.ProductGetterExpecteds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProductGetterControllerTest {

    private ProductGetterController controller;

    @Before
    public void setUp(){
        ProductGetterService service = mock(ProductGetterService.class);

        when(service.getAllProducts()).thenReturn(ProductGetterExpecteds.EXPECTED_LIST);

        controller = new ProductGetterController(service);
    }

    @Test
    public void testGetAllProducts(){
        ProductListResponseDto actual = controller.getAllProducts();

        Assert.assertEquals(ProductGetterExpecteds.EXPECTED_LIST,actual);
    }
}