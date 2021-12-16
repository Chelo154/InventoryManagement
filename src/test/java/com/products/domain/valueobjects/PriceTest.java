package com.products.domain.valueobjects;

import com.products.domain.exceptions.InvalidPriceException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PriceTest {

    @Test
    public void priceCreationTest(){
        Price price = new Price(10);
    }

    @Test
    public void priceCreation0ValueTest(){
        Price price = new Price(0);
    }

    @Test
    public void invalidPriceCreationTest(){
        Assert.assertThrows(InvalidPriceException.class,() -> {
            Price price = new Price(-1);
        });
    }

}