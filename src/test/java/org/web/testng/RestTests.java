package org.web.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.collections.web.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.http.ContentType.JSON;

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
        requestSpecification.queryParam("inc", "gender,name,nat,id");
      //  requestSpecification.queryParam("id", "name, value");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", 5);
        Response response = requestSpecification.get();
        response.prettyPrint();
        System.out.println(response.jsonPath().get("results[0].gender").toString());

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(JSON);

        ResultsDto dto = response.as(ResultsDto.class);

        System.out.println(dto.getResults().size());
        Assert.assertEquals(dto.getResults().get(0).getGender(), "male");
    }

    @Test
    public void testRestAssuredImproved() {
        RestAssured.baseURI = "https://randomuser.me/";
        ResultsDto dto = RestAssured.given()
                .basePath("/api")
                .queryParam("inc", "gender,name,nat,id")
                .queryParam("noinfo")
                .queryParam("results", 5)
                .get()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .as(ResultsDto.class);

        ArrayList<String> genders = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            genders.add(dto.getResults().get(i).getGender());
            System.out.println(dto.getResults().get(i).getGender());
        }

        System.out.println(dto.getResults());
        Assert.assertTrue(genders.contains("male"));
       // Assert.assertEquals(dto.getResults().get(0).getGender(), "male");
    }
}
