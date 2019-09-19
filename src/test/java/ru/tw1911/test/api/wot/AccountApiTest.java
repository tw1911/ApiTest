package ru.tw1911.test.api.wot;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class AccountApiTest extends BaseTest{

    @Test
    public void printBaseUrl(){
        System.out.println(baseUrl);
    }

    @Test
    public void searchAccountTest(){
        get(baseUrl+ "account/list/?application_id=c52fbe5e23e9ae2bb7b57c5f3007ae0b&search=tw1911").then().statusCode(200);
    }
}
