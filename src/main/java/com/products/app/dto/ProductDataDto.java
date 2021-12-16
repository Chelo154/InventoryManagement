package com.products.app.dto;

import com.products.app.interfaces.Mapeable;
import com.products.domain.entities.Product;

public class ProductDataDto implements Mapeable<Product> {
    private String id;
    private String description;
    private double cost;
    private double profit;

    public ProductDataDto(String id, String description, double cost, double profit){
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.profit = profit;
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

    @Override
    public Product map() {
        return new Product(
                id,
                description,
                cost,
                profit
        );
    }
}
