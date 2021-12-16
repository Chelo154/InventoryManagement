package com.products.infra.enviroment;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvHandler {

    private Dotenv dotenv;

    private static DotenvHandler handler;

    public DotenvHandler(){
        dotenv = Dotenv.load();
    }

    public String getEnv(String variable){
        return dotenv.get(variable);
    }

    public static DotenvHandler getHandler(){
        if(handler == null) handler = new DotenvHandler();
        return  handler;
    }

}
