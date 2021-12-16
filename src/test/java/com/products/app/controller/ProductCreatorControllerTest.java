package com.products.app.controller;

import com.products.app.dto.ProductCreatorDto;
import com.products.app.exceptions.InvalidDtoException;
import com.products.app.dto.ProductInfoResponseDto;
import com.products.app.service.ProductCreatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
public class ProductCreatorControllerTest {

    private ProductCreatorController controller;

    @Before
    public void setUp(){
        ProductCreatorService service = mock(ProductCreatorService.class);

        when(service.createProduct(any())).thenReturn(new ProductInfoResponseDto(
                "abc123",
                "Batman Comic",
                100,
                20,
                120
        ));

        controller = new ProductCreatorController(service);
    }

    @Test
    public void testProductCreation(){
        ProductCreatorDto dto = new ProductCreatorDto("Batman Comic",100,20);

        ProductInfoResponseDto response = controller.createProduct(dto);

        Assert.assertEquals("abc123",response.getId());
        Assert.assertEquals("Batman Comic",response.getDescription());
        Assert.assertEquals(100,response.getCost(),0);
        Assert.assertEquals(20,response.getProfit(),0);
        Assert.assertEquals(120,response.getSalePrice(),0);

    }

    @Test
    public void testMissingDescriptionOnProductCreation(){
        Assert.assertThrows("ProductCreatorDto is not valid, please send a valid ProductCreatorDto",
                InvalidDtoException.class,
                () ->{
                    controller.createProduct(new ProductCreatorDto(null,100,20));
                });
    }

}