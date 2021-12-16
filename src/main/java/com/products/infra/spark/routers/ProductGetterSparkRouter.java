package com.products.infra.spark.routers;

import com.google.gson.Gson;
import com.products.app.controller.ProductGetterController;
import com.products.app.dto.ProductListResponseDto;
import com.products.app.exceptions.ProductGetterException;
import com.products.app.service.ProductGetterService;
import com.products.infra.gcp.mysql.GcpMysqlProductGetter;
import com.products.infra.mongodb.MongoDBProductGetter;
import com.products.infra.spark.responses.ProductGetterErrorResponse;

import static spark.Spark.*;

public class ProductGetterSparkRouter extends SparkRouter{

    private ProductGetterController controller;
    private Gson gson;

    public ProductGetterSparkRouter(){
        this.controller = new ProductGetterController(
                new ProductGetterService(new GcpMysqlProductGetter())
        );
        this.gson = new Gson();
    }

    @Override
    public void loadRoute() {
        get("/product/",((request, response) -> {
            try{
                ProductListResponseDto products = controller.getAllProducts();

                response.status(200);

                response.body(gson.toJson(products));
            }catch (ProductGetterException error1){
                response.status(500);

                response.body(gson.toJson(new ProductGetterErrorResponse(error1)));
            }

            response.type("application/json");

            return response.body();

        })
        );
    }
}
