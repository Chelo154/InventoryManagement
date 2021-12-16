package com.main;

import com.microservices.Microservice;
import com.products.infra.spark.microservice.SparkMicroservice;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Microservice> microservices;

    public static void main(String[] args) {
        microservices = new ArrayList<>();

        loadMicroservices();

        microservices.forEach(Microservice::start);
    }

    private static void loadMicroservices(){
        microservices.add(new SparkMicroservice());
    }
}
