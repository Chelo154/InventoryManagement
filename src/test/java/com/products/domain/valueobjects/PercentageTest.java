package com.products.domain.valueobjects;

import com.products.domain.exceptions.InvalidPercentageException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PercentageTest {

    @Test
    public void percentageCreationTest(){
        Percentage percentage = new Percentage(10);
    }

    @Test
    public void percentageCreationCeroValueTest(){
        Percentage percentage = new Percentage(0);
    }

    @Test
    public void invalidPercentageCreationTest(){
        Assert.assertThrows(InvalidPercentageException.class,() ->{
            new Percentage(-1);
        });
    }

    @Test
    public void calculatePercentageTest(){
        Percentage percentage = new Percentage(20);

        double expected = 200;

        double actual = percentage.calculatePercentage(1000);

        Assert.assertEquals(expected,actual,0);
    }

}