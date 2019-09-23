package ru.tw1911.test.api.wot.util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Properties;

public class RestUtils {
    public static RequestSpecification getRuestSpecification(){
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec.addParam("application_id",properties.getProperty("test.wg.application_id"));
        spec.setBaseUri(properties.getProperty("test.base.url"));
        return spec.build();
    }

}
