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
    private final static String INSERT_BASE = "INSERT INTO FlightDest (CITY_NAME, PRICE) VALUES ('%s', %s)";
    private final static String LOAD_CITY_INFORMATION = "Select CITY_NAME, PRICE from FlightDest where CITY_NAME = '%s'";
    private final static String UPDATE_CITY_PRICE = "UPDATE FlightDest SET PRICE = %s WHERE CITY_NAME = '%s'";

   // public static GooglePage googlePage;
    public static FinnAirPage finnAirPage;

  //  protected WebDriver driver;


    @Given("I accept cookies on Finnair if present")
    public void acceptCoockies(){
        finnAirPage.localSetUp();
        if (finnAirPage.isElementVisible()) {
            finnAirPage.coockieModalClose();
        }
    }

    @Given("I go to the Destination Page")
    public void openDestinationPage(){
        finnAirPage.openFinlandDestination();
    }

//    @Given("I create a list with top {int} Finnair Flights")
//    public void createFlightList(int alias){
//        finnAirPage.getFlights2(alias);
//    }

//    @Given("I create a list with top {int} Finnair Flights")
//    public Map<String, Float> getFlights(int alias) {
//
//        List<WebElement> cityNames = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(CITY_NAME));
//        List<WebElement> prices = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(CITY_PRICE));
//
//
//        Map<String, Float> data = new HashMap<>();
//        for (int idx = 0; idx < alias; idx++) {
//            String cityName = cityNames.get(idx).getText();
//
//            String rawPrice = prices.get(idx).getText().split(" ")[0];
//            Float price = Float.parseFloat(rawPrice);
//
//            data.put(cityName, price);
//        }
//
//        return data;
//    }


//    @Then("I store to db new flight to {int} cities or flight with updated prices")
//    public static void assertCityPrice(int alias) throws SQLException {
//        Map<String, Float> flights = FinnAirPage.getFlightsprices(alias);
//        SoftAssert softAssert = new SoftAssert();
//        for (Map.Entry<String, Float> e : flights.entrySet()) {
//            String cityName = e.getKey();
//            Float price = e.getValue();
//
//            Map<String, Float> persistenceData = DbUtil.loadPrice(cityName);
//            if (!persistenceData.containsKey(cityName)) {
//                String insert = String.format(INSERT_BASE, cityName, price);
//                DbUtil.storeInDB(insert);
//                continue;
//            }
//
//            Float persistencePrice = persistenceData.get(cityName);
//
//            if (price.equals(persistencePrice)) {
//                continue;
//            }
//
//            String update = String.format(UPDATE_CITY_PRICE, cityName, price);
//            DbUtil.storeInDB(update);
//            softAssert.fail("Price was updated and fail test");
//        }
//        softAssert.assertAll();
//    }
}
