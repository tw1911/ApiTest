package ru.tw1911.test.api.wot;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.tw1911.test.api.wot.model.Account;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AccountSearchTests extends BaseTest{

    @BeforeClass
    public void setTestClass(){
        RestAssured.requestSpecification.basePath("account/list/");
    }

    @Test
    public void searchAccountTest(){
        given()
                .queryParam("search","alex")
                .get()
                .then().statusCode(200)
                .and()
                .body("status", equalTo("ok"));
    }

    @Test
    public void defaultSearchOutputLimitTest(){
        List<Account> accounts =  given()
                .queryParam("search","alex")
                .get()
                .jsonPath().getList("data",Account.class);
        assertThat(accounts.size(), is(100));
    }

    @Test
    public void limitOver100Test(){
        List<Account> accounts =  given()
                .queryParam("search","alex")
                .queryParam("limit",120)
                .get()
                .jsonPath().getList("data",Account.class);
        assertThat(accounts.size(), is(100));
    }

    @Test
    public void searchOutputLimitTest(){
        List<Account> accounts =  given()
                .queryParam("search","alex")
                .queryParam("limit",50)
                .get()
                .jsonPath().getList("data",Account.class);
        assertThat(accounts.size(), is(50));
    }

    @Test
    public void exactSearchTest(){
        List<Account> accounts =  given()
                .queryParam("search","alex")
                .queryParam("type","exact")
                .get()
                .jsonPath().getList("data",Account.class);
        assertThat(accounts.size(),is(1));
    }

    @Test
    public void emptySearchParameterTest(){
        given()
                .queryParam("search","")
                .get()
                .then().assertThat().statusCode(200)
                .body("status", equalTo("error"))
                .body("error.message",equalTo("SEARCH_NOT_SPECIFIED"))
                .body("error.code", equalTo(402));
    }
}
