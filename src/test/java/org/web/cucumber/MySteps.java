package org.web.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.collections.web.dto.PersonDto;
import org.collections.web.dto.ResultsDto;
import org.collections.web.page.GooglePage;
import org.collections.web.util.CucumberContainer;
import org.collections.web.util.DbUtil;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertNotNull;

public class MySteps {

    public static GooglePage googlePage;



    @Given("I store group {string} in my DB")
    public void storePersonInDB(String alias) {
        List<PersonDto> randomPersons = (List<PersonDto>) CucumberContainer.map.get(alias);
        assertNotNull(randomPersons,
                "Please use 'request random persons' step before invoking this");
        randomPersons.forEach(p -> DbUtil.storeInDB(p.getInsertSQL()));
    }

    @Given("I load google page")
    public void loadGooglePage() {
        googlePage.loadPage();
    }

    @Given("I accept cookies if present")
    public void acceptCookiesIfPresent() {
        googlePage.acceptCookiesIfPresent();
    }

    @When("I google for person with alias {string}")
    public void googleForRandomPerson(String alias) {
        googlePage.setSearchText((String) CucumberContainer.map.get(alias));
        googlePage.performSearch();
    }

    @Then("I can see name of person with alias {string} in search results")
    public void validateSearchResultCount(String alias) {
        String name = (String) CucumberContainer.map.get(alias);
        Assert.assertTrue(
                googlePage.getSearchHeaders()
                        .stream()
                        .anyMatch(
                                we -> we.getText().toUpperCase().contains(name.toUpperCase())),
                "No person with this name found! " + name
        );
    }
}
