package org.web.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.collections.web.page.DbMethods;
import org.collections.web.page.FinnAirPage;
import org.collections.web.page.GooglePage;
import org.collections.web.util.DbUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinnairSteps {

    public final static By CITY_NAME = By.xpath("//*[@id=\"search-result-wrapper\"]//a/h3");
    public final static By CITY_PRICE = By.xpath("//*[@id=\"search-result-wrapper\"]//section[2]/a/span");


    public static FinnAirPage finnAirPage;


    @Given("I accept cookies on Finnair if present")
    public void acceptCoockies() {
        finnAirPage.localSetUp();
        if (finnAirPage.isElementVisible()) {
            finnAirPage.coockieModalClose();
        }
    }

    @Given("I go to the Destination Page")
    public void openDestinationPage() {
        finnAirPage.openFinlandDestination();
    }

    @When("I try to search {string}")
    public void finnairSearch(String alias) {
        finnAirPage.closeJoinFinnairPlus();
        finnAirPage.search(alias);
    }

    @Then("I check that there is {string} in the url")
    public void checkFinnairSearchResult(String alias) {
        finnAirPage.searcResultsCheck();
        String currentUrl = finnAirPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(alias),
                "Expected to be at " + alias + ", but was at " + currentUrl);
    }

    @When("I try to login without credentials")
    public void tryLoginWithoutCreds() {
        finnAirPage.openLoginModal();
        finnAirPage.userNameFieldClick();
        finnAirPage.loginButtonClick();
        finnAirPage.passFieldClick();
        finnAirPage.loginButtonClick();
    }

    @Then("I see error messges below inputs")
    public void checkErrorMessagesFinnairLogin() {
        String nameerror;
        String paserror;
        nameerror = finnAirPage.getUserNameError();
        paserror = finnAirPage.getPassError();
        Assert.assertTrue(nameerror.contains("Email address or Finnair Plus number is required"), "Expected to be Email address or Finnair Plus number is required, but was a" + paserror);
        Assert.assertTrue(paserror.contains("Password is required"), "Expected Password is required, but was a" + paserror);

    }

}


