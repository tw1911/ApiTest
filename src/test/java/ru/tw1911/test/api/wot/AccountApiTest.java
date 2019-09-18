package ru.tw1911.test.api.wot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountApiTest {
    @Value("${test.base.url}")
    private String baseUrl;

    @Test
    public void printBaseUrl(){
        System.out.println(baseUrl);
    }

    @Test
    public void searchAccountTest(){
        get(baseUrl+ "account/list/?application_id=c52fbe5e23e9ae2bb7b57c5f3007ae0b&search=tw1911").then().statusCode(200);
    }
}
