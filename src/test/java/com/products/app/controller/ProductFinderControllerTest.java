package com.products.app.controller;

import com.products.app.dto.ProductInfoResponseDto;
import com.products.app.exceptions.MissingIdException;
import com.products.app.exceptions.ProductNotFoundException;
import com.products.app.service.ProductFinderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProductFinderControllerTest {

    private ProductFinderController controller;

    @Before
    public void setUp(){
        ProductFinderService service = mock(ProductFinderService.class);

        when(service.findById("abc123")).thenReturn(new ProductInfoResponseDto(
                "abc123",
                "Batman Comic",
                100,
                20,
                120
        ));

        when(service.findById("wrong")).thenThrow(new ProductNotFoundException("wrong"));

        controller = new ProductFinderController(service);
    }

    @Test
    public void testFindProduct(){
        ProductInfoResponseDto actual = controller.findProductById("abc123");

        Assert.assertEquals("abc123",actual.getId());
        Assert.assertEquals("Batman Comic",actual.getDescription());
        Assert.assertEquals(100,actual.getCost(),0);
        Assert.assertEquals(20,actual.getProfit(),0);
        Assert.assertEquals(120,actual.getSalePrice(),0);
    }

    @Test
    public void testNullId(){
        Assert.assertThrows(MissingIdException.class,()->{
            controller.findProductById(null);
        });
    }

    @Test
    public void testEmptyId(){
        Assert.assertThrows(MissingIdException.class,()->{
            controller.findProductById("");
        });
    }

    @Test
    public void testProductNotFound(){
        Assert.assertThrows(ProductNotFoundException.class,()->{
            controller.findProductById("wrong");
        });
    }

}