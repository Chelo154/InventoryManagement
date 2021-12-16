package com.products.app.service;

import com.products.app.dto.ProductCreatorDto;
import com.products.app.dto.ProductInfoResponseDto;
import com.products.app.interfaces.IdGenerator;
import com.products.app.interfaces.ProductSaver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProductCreatorServiceTest {

    private ProductCreatorService service;

    @Before
    public void setUp(){
        IdGenerator idGenerator = mock(IdGenerator.class);
        ProductSaver saver = mock(ProductSaver.class);

        when(idGenerator.generateId()).thenReturn("abc123");

        doNothing().when(saver).save(any());

        service = new ProductCreatorService(idGenerator,saver);
    }

    @Test
    public void testServiceCreation(){
        ProductCreatorDto dto = new ProductCreatorDto(
                "Batman Comic",
                100,
                20
        );


        ProductInfoResponseDto response = service.createProduct(dto);

        Assert.assertEquals(response.getId(),"abc123");
        Assert.assertEquals(response.getDescription(),"Batman Comic");
        Assert.assertEquals(response.getCost(),100,0);
        Assert.assertEquals(response.getProfit(),20,0);
        Assert.assertEquals(response.getSalePrice(),120,0);

    }

}