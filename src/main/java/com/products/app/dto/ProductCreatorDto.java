package com.products.app.dto;

public class ProductCreatorDto {
    private String description;
    private double cost;
    private double profit;

    public ProductCreatorDto(){
        this(null,0,0);
    }

    public ProductCreatorDto(String description, double cost, double profit){
        this.description = description;
        this.cost = cost;
        this.profit = profit;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValid(){
        return description != null;
    }
}
