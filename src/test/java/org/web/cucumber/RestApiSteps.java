package org.web.cucumber;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.collections.web.dto.ResultsDto;
import org.collections.web.util.CucumberContainer;

public class RestApiSteps {

    @Given("I request {int} random persons from API as {string}")
    public void requestPersonFromApi(int amount, String alias) {
        RestAssured.baseURI = "https://randomuser.me/";
        CucumberContainer.map.put(alias, RestAssured.given()
                .basePath("/api")
                .queryParam("inc", "gender,name,nat")
                .queryParam("noinfo")
                .queryParam("results", amount)
                .get()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .as(ResultsDto.class)
                .getResults());
    }
}
