package com.products.infra.gcp.mysql;

import com.products.app.dto.ProductDataDto;
import com.products.app.interfaces.ProductSaver;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class GcpMySqlProductSaver extends GcpMySqlConnector implements ProductSaver {

    @Override
    public void save(ProductDataDto product) {

        String storedProcedure = "{CALL CreateProduct(?,?,?,?)}";

        try (Connection connection = connect()){
            CallableStatement statement = connection.prepareCall(storedProcedure);

            statement.setString(1,product.getId());
            statement.setString(2,product.getDescription());
            statement.setDouble(3,product.getCost());
            statement.setDouble(4,product.getProfit());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
