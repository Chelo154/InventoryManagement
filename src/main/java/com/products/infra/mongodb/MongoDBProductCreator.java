package com.products.infra.mongodb;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.products.app.dto.ProductDataDto;
import com.products.app.exceptions.ProductSaverException;
import com.products.app.interfaces.ProductSaver;
import org.bson.Document;

public class MongoDBProductCreator extends MongoDBConnector implements ProductSaver {
    @Override
    public void save(ProductDataDto dto) {
       try(MongoClient client = connect()){

           MongoDatabase database = client.getDatabase(dotenv.getEnv("MONGODB_DATABASE"));

           MongoCollection<Document> collection = database.getCollection(dotenv.getEnv("MONGODB_COLLECTION"));

           collection.insertOne(new Document()
                   .append("_id",dto.getId())
                   .append("description",dto.getDescription())
                   .append("cost",dto.getCost())
                   .append("profit",dto.getProfit())
           );

       }catch (MongoException error){
           throw new ProductSaverException(getClass().getSimpleName(),error.getMessage());
       }
    }
}
