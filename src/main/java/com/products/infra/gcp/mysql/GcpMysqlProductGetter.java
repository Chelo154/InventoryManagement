package com.products.infra.gcp.mysql;

import com.products.app.dto.ProductDataDto;
import com.products.app.exceptions.ProductGetterException;
import com.products.app.interfaces.ProductGetter;
import com.products.domain.entities.Product;
import org.checkerframework.checker.units.qual.A;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GcpMysqlProductGetter extends GcpMySqlConnector implements ProductGetter {

    @Override
    public ArrayList<ProductDataDto> getProducts() {

        String sql = "SELECT * FROM products";

        try(Connection connection = connect()){
            ArrayList<ProductDataDto> productDataDtos = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                productDataDtos.add(new ProductDataDto(
                        resultSet.getString("id"),
                        resultSet.getString("description"),
                        resultSet.getDouble("cost"),
                        resultSet.getDouble("profit")
                ));
            }

            return  productDataDtos;

        }
        catch (SQLException error1){
            throw new ProductGetterException(error1.getMessage(),getClass().getSimpleName());
        }
    }
}
