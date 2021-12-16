package com.products.infra.gcp.mysql;

import org.junit.Before;
import org.junit.Test;

public class MySqlConnectorTest {

    private GcpMySqlConnector connector;

    @Before
    public void setUp(){
        connector = new GcpMySqlConnector(){
            public void testConnection(){
                this.connect();
            }
        };
    }

    @Test
    public void testConnection(){
        connector.connect();
    }

}