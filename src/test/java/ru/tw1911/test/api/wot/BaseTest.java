package ru.tw1911.test.api.wot;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected String baseUrl;

    @BeforeClass
    public void initProperties() throws IOException {
        System.out.println("beforeClass");
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        baseUrl=properties.getProperty("test.base.url");
    }
}