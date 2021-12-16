package com.products.app.dto;

import com.products.app.interfaces.Mapeable;
import com.products.domain.entities.Product;

public class ProductInfoResponseDto {
    private String id;
    private String description;
    private double cost;
    private double profit;
    private double salePrice;

    public ProductInfoResponseDto(
            String id,
            String description,
            double cost,
            double profit,
            double salePrice
    ){
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.profit = profit;
        this.salePrice = salePrice;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public double getProfit() {
        return profit;
    }

    public double getSalePrice() {
        return salePrice;
    }
}
