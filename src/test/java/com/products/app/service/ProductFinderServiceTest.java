package com.products.app.service;

import com.products.app.dto.ProductDataDto;
import com.products.app.dto.ProductInfoResponseDto;
import com.products.app.exceptions.ProductNotFoundException;
import com.products.app.interfaces.ProductFinder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProductFinderServiceTest {

    private ProductFinderService service;

    @Before
    public void setUp(){
        ProductFinder finder = mock(ProductFinder.class);

        when(finder.findById("abc123")).thenReturn(
                new ProductDataDto(
                        "abc123",
                        "Batman Comic",
                        100,
                        20
                )
        );

        when(finder.findById("wrong")).thenReturn(null);

        service = new ProductFinderService(finder);
    }

    @Test
    public void testFindProductByCorrectId(){
        ProductInfoResponseDto actual = service.findById("abc123");

        Assert.assertEquals("abc123",actual.getId());
        Assert.assertEquals("Batman Comic",actual.getDescription());
        Assert.assertEquals(100,actual.getCost(),0);
        Assert.assertEquals(20,actual.getProfit(),0);
        Assert.assertEquals(120,actual.getSalePrice(),0);
    }

    @Test
    public void testFindProductByIncorrectId(){
        Assert.assertThrows(ProductNotFoundException.class,()->{
            service.findById("wrong");
        });
    }
}