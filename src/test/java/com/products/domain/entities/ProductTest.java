package com.products.domain.entities;

import com.products.domain.exceptions.InvalidPercentageException;
import com.products.domain.exceptions.InvalidPriceException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void productCreationTest(){
        Product product = new Product("abc123","Batman Comic",100,20);

        Assert.assertEquals("abc123",product.getId());
        Assert.assertEquals("Batman Comic",product.getDescription());
        Assert.assertEquals(100,product.getCost(),0);
        Assert.assertEquals(20,product.getProfit(),0);
    }

    @Test
    public void invalidPriceProductCreationTest(){
        Assert.assertThrows(InvalidPriceException.class, ()->{
            new Product("abc123","Batman Comic",-10,20);
        });
    }

    @Test
    public void invalidProfitProductCreationTest(){
        Assert.assertThrows("-10.00 is not a valid percentage",
                InvalidPercentageException.class, ()->{
                    new Product("abc123","Batman Comic",100,-20);
                });
    }

    @Test
    public void testCommercialPrice(){
        Product product = new Product("abc123","Batman Comic",100,20);

        double expected = 120;

        double actual = product.getSalesPrice();

        Assert.assertEquals(expected,actual,0);
    }
}