package com.products.infra.spark.routers;
import com.google.gson.Gson;
import com.products.app.controller.ProductCreatorController;
import com.products.app.dto.ProductCreatorDto;
import com.products.app.dto.ProductInfoResponseDto;
import com.products.app.exceptions.InvalidDtoException;
import com.products.app.exceptions.ProductSaverException;
import com.products.app.service.ProductCreatorService;
import com.products.domain.exceptions.InvalidPercentageException;
import com.products.domain.exceptions.InvalidPriceException;
import com.products.infra.gcp.mysql.GcpMySqlProductSaver;
import com.products.infra.mongodb.MongoDBProductCreator;
import com.products.infra.spark.responses.Error400Response;
import com.products.infra.spark.responses.ProductGetterErrorResponse;
import com.products.infra.uuid.UuidGenerator;

import static spark.Spark.*;

public class CreateProductSparkRouter extends SparkRouter{

    private final ProductCreatorController controller;


    public CreateProductSparkRouter(){
        this.controller = new ProductCreatorController(
                new ProductCreatorService(
                        new UuidGenerator(),
                        new MongoDBProductCreator()
                )
        );
    }

    @Override
    public void loadRoute() {
        post("/product/",(req,res)->{
            Gson gson = new Gson();
            try{
                ProductCreatorDto dto = gson.fromJson(req.body(),ProductCreatorDto.class);

                ProductInfoResponseDto response = controller.createProduct(dto);

                res.status(200);
                res.body(gson.toJson(response));
            }catch(InvalidDtoException| InvalidPercentageException | InvalidPriceException error1 ){
                res.status(400);
                res.body(gson.toJson(new Error400Response(error1)));

            }
            catch (ProductSaverException error2){
                res.status(500);
                res.body(gson.toJson(error2.getDetails()));
            }
            res.type("application/json");
            return res.body();
        });
    }
}
