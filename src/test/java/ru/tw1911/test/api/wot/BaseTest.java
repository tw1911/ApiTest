package ru.tw1911.test.api.wot;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import ru.tw1911.test.api.wot.util.RestUtils;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    @BeforeClass
    public void initProperties() throws IOException {
        RestAssured.requestSpecification = RestUtils.getRuestSpecification();
    }
}
