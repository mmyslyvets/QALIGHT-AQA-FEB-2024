package org.web.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.collections.web.page.DbMethods;
import org.collections.web.page.FinnAirPage;
import org.collections.web.page.GooglePage;
import org.collections.web.util.DbUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
}
