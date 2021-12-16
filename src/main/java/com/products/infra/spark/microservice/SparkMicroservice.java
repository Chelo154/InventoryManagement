package com.products.infra.spark.microservice;

import com.microservices.Microservice;
import com.products.infra.spark.routers.CreateProductSparkRouter;
import com.products.infra.spark.routers.ProductGetterSparkRouter;
import com.products.infra.spark.routers.SparkRouter;

import java.util.ArrayList;

import static spark.Spark.*;

public class SparkMicroservice implements Microservice {

    private ArrayList<SparkRouter> routers;

    public SparkMicroservice(){
        this.routers = new ArrayList<>();
        loadRoutes();
    }

    @Override
    public void start() {
        port(8080);
        routers.forEach(SparkRouter :: loadRoute);
    }

    private void loadRoutes(){
        routers.add(new CreateProductSparkRouter());
        routers.add(new ProductGetterSparkRouter());
    }
}