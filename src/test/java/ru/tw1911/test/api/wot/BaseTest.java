package ru.tw1911.test.api.wot;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected String application_id;

    @BeforeClass
    public void initProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));

        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec.addParam("application_id",properties.getProperty("test.wg.application_id"));
        spec.setBaseUri(properties.getProperty("test.base.url"));
        RestAssured.requestSpecification = spec.build();

   //     application_id=properties.getProperty("test.wg.application_id");
    //    RestAssured.baseURI = properties.getProperty("test.base.url");
    }
}
