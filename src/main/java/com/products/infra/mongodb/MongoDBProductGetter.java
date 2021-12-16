package com.products.infra.mongodb;

import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.products.app.dto.ProductDataDto;
import com.products.app.interfaces.ProductGetter;
import org.bson.Document;

import java.util.ArrayList;

public class MongoDBProductGetter extends MongoDBConnector implements ProductGetter {
    @Override
    public ArrayList<ProductDataDto> getProducts() {
        ArrayList<ProductDataDto> dtos = new ArrayList<>();

        try(MongoClient client = connect()){
            MongoDatabase database = client.getDatabase(dotenv.getEnv("MONGODB_DATABASE"));

            MongoCollection<Document> collection = database.getCollection(dotenv.getEnv("MONGODB_COLLECTION"));

            try (MongoCursor<Document> cursor = collection.find().cursor()) {
                while (cursor.hasNext()) {
                    Document item = cursor.next();

                    dtos.add(new ProductDataDto(
                            item.getString("_id"),
                            item.getString("description"),
                            item.getDouble("cost"),
                            item.getDouble("profit")
                    ));
                }
            }

            return dtos;
        }
    }
}
