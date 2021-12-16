package com.products.app.service;

import com.products.app.dto.ProductInfoResponseDto;
import com.products.app.dto.ProductListResponseDto;
import com.products.app.interfaces.ProductGetter;
import com.products.expecteds.ProductGetterExpecteds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductGetterServiceTest {

    private ProductGetterService service;

    @Before
    public void setUp(){
        ProductGetter getter = mock(ProductGetter.class);

        when(getter.getProducts()).thenReturn(new ArrayList<>(Arrays.asList(ProductGetterExpecteds.DATA_EXPECTEDS)));

        service = new ProductGetterService(getter);

    }


    @Test
    public void testGetProducts(){

        ProductListResponseDto expected = ProductGetterExpecteds.EXPECTED_LIST;

        ProductListResponseDto actual = service.getAllProducts();

        deepEqual(expected,actual);
    }


    private void deepEqual(ProductListResponseDto expected, ProductListResponseDto actual){

        ProductInfoResponseDto[]expectedItems = expected.products.toArray(ProductInfoResponseDto[]::new);
        ProductInfoResponseDto[]actualItems = actual.products.toArray(ProductInfoResponseDto[]::new);

        Assert.assertEquals(expectedItems.length,actualItems.length);

        for(int i =0; i < expectedItems.length; i++){
            Assert.assertEquals(expectedItems[i].getId(),actualItems[i].getId());

            Assert.assertEquals(expectedItems[i].getDescription(),actualItems[i].getDescription());

            Assert.assertEquals(expectedItems[i].getCost(),actualItems[i].getCost(),0);

            Assert.assertEquals(expectedItems[i].getProfit(),actualItems[i].getProfit(),0);

            Assert.assertEquals(expectedItems[i].getSalePrice(),actualItems[i].getSalePrice(),0);
        }
    }
}