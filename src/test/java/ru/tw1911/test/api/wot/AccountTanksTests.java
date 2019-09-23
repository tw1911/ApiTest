package ru.tw1911.test.api.wot;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AccountTanksTests extends BaseTest{
    @BeforeClass
    public void setTestClass(){
        RestAssured.requestSpecification.basePath("account/tanks/");
    }

    @Test
    public void getSingleAccountTanksList(){
        given()
                .queryParam("account_id",getAccountId("tw1911"))
                .get()
                .then().statusCode(200);
    }

    @Test
    public void getMultipleAccountsTanksList(){
        given()
                .queryParam("account_id",
                        getAccountId("tw1911"),
                        getAccountId("Forest"))
                .get()
                .then().statusCode(200);
    }

    @Test void getSingleTankStatistics(){

    }

    @Test void getSomeTanksStatistics(){

    }

    @Test void fieldFilterTest(){

    }

    private String getAccountId(String nickname){
        return RestAssured.with()
                .queryParam("search",nickname)
                .queryParam("type","exact").basePath("account/list/")
                .get().jsonPath().getString("data[0].account_id");
    }
}
