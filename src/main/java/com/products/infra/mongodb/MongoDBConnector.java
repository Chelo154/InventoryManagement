package com.products.infra.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.products.infra.enviroment.DotenvHandler;

public class MongoDBConnector {

    protected DotenvHandler dotenv;

    public MongoDBConnector(){
        this.dotenv = DotenvHandler.getHandler();
    }

    public MongoClient connect(){
        return MongoClients.create(dotenv.getEnv("MONGODB_URI"));
    }
}
