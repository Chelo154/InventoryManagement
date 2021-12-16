package com.products.domain.entities;

import com.products.domain.valueobjects.Percentage;
import com.products.domain.valueobjects.Price;

public class Product {
    private String id;
    private String description;
    private Price cost;
    private Percentage profit;


    public Product(String id, String description, double price, double profit){
        this.id = id;
        this.description = description;
        this.cost = new Price(price);
        this.profit = new Percentage(profit);
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost.getValue();
    }

    public double getProfit(){
        return profit.getValue();
    }

    public double getSalesPrice(){
        double salePrice = cost.getValue();
        return salePrice + profit.calculatePercentage(salePrice);
    }
}
