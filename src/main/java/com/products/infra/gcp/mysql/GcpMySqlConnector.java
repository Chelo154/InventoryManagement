package com.products.infra.gcp.mysql;
import com.products.app.exceptions.ProductSaverException;
import com.products.infra.enviroment.DotenvHandler;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class GcpMySqlConnector {

    private final DotenvHandler envHandler;

    public GcpMySqlConnector(){
        envHandler = DotenvHandler.getHandler();
    }

    protected Connection connect(){

        String jdbcUrl = String.format("jdbc:mysql://%s", envHandler.getEnv("CLOUD_SQL_DATABASE"));

        Properties connectionsProperties = new Properties();

        connectionsProperties.setProperty("user",envHandler.getEnv("CLOUD_SQL_USER"));
        connectionsProperties.setProperty("password",envHandler.getEnv("CLOUD_SQL_PASSWORD"));
        connectionsProperties.setProperty("socketFactory","com.google.cloud.sql.mysql.SocketFactory");
        connectionsProperties.setProperty("cloudSqlInstance",envHandler.getEnv("CLOUD_SQL_INSTANCE"));

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(jdbcUrl);
        config.setDataSourceProperties(connectionsProperties);
        config.setConnectionTimeout(10000);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        HikariDataSource connectionPool = new HikariDataSource(config);

        try {
            return connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ProductSaverException(this.getClass().getSimpleName(),e.getMessage());
        }
    }
}
