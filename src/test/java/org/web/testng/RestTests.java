package org.web.testng;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.collections.web.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestTests {

    //    https://randomuser.me/api/?inc=gender,name,nat&noinfo
    // TODO: Add 'id' to 'inc' query params
    // TODO: print id.name and id.value to console
    // TODO*: Request 5 persons, and write assertion that there is at least 1 female person
    @Test
    public void testRestAssured() {
        RestAssured.baseURI = "https://randomuser.me/";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.basePath("/api");
//        requestSpecification.body("test-body");
        requestSpecification.queryParam("inc", "gender,name,nat");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", 5);
        Response response = requestSpecification.get();
        response.prettyPrint();
        System.out.println(response.jsonPath().get("results[0].name.first").toString());

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);

        ResultsDto dto = response.as(ResultsDto.class);

        System.out.println(dto.getResults().size());
        Assert.assertEquals(dto.getResults().get(0).getGender(), "male");
    }

    @Test
    public void testRestAssuredImproved() throws JsonProcessingException {
        RestAssured.baseURI = "https://randomuser.me/";
        ResultsDto dto = RestAssured.given()
                .basePath("/api")
                .queryParam("inc", "gender,name,nat")
                .queryParam("noinfo")
                .queryParam("results", 5)
                .get()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .as(ResultsDto.class);

        System.out.println(dto.getResults().size());
        Assert.assertEquals(dto.getResults().get(0).getGender(), "male");
    }
}
