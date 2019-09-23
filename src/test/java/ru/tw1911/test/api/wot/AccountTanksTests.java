package ru.tw1911.test.api.wot;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.tw1911.test.api.wot.model.Tank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class AccountTanksTests extends BaseTest {
    @BeforeClass
    public void setTestClass() {
        RestAssured.requestSpecification.basePath("account/tanks/");
    }

    @Test
    public void getSingleAccountTanksList() {
        String accId = getAccountId("tw1911");
        List<Tank> tanks = given()
                .queryParam("account_id", accId)
                .get().then().statusCode(200).extract().jsonPath().getList("data." + accId, Tank.class);
        assertThat(tanks.size(), is(88));

    }

    @Test
    public void getMultipleAccountsTanksList() {
        Map<String, ArrayList> result = given()
                .queryParam("account_id",
                        getAccountId("tw1911")
                                + "," +
                                getAccountId("Forest"))
                .get()
                .then().statusCode(200).extract().jsonPath().getMap("data", String.class, ArrayList.class);
        assertThat(result.size(), is(2));
        assertThat(result.get(getAccountId("tw1911")).size(), is(88));
        assertThat(result.get(getAccountId("Forest")).size(), is(7));
    }

    @Test
    void getSingleTankStatistics() {
        String accId = getAccountId("tw1911");
        List<Tank> tanks = given()
                .queryParam("account_id", accId)
                .queryParam("tank_id", 1)
                .get().then().statusCode(200).extract().jsonPath().getList("data." + accId, Tank.class);
        assertThat(tanks.size(), is(1));
    }

    @Test
    void getSomeTanksStatistics() {
        String accId = getAccountId("tw1911");
        List<Tank> tanks = given()
                .queryParam("account_id", accId)
                .queryParam("tank_id", "1,7937,2561")
                .get().then().statusCode(200).extract().jsonPath().getList("data." + accId, Tank.class);
        assertThat(tanks.size(), is(3));
    }

    @Test
    void fieldFilterTest() {
        String accId = getAccountId("tw1911");
        List<Tank> tanks = given()
                .queryParam("account_id", accId)
                .queryParam("tank_id", 1)
                .queryParam("fields","tank_id")
                .get().then().statusCode(200).extract().jsonPath().getList("data." + accId, Tank.class);
        assertThat(tanks.size(), is(1));
        assertThat(tanks.get(0).getStatistics(),nullValue());
    }

    private String getAccountId(String nickname) {
        return RestAssured.with()
                .queryParam("search", nickname)
                .queryParam("type", "exact").basePath("account/list/")
                .get().jsonPath().getString("data[0].account_id");
    }
}
