package org.web.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.collections.web.dto.PersonDto;
import org.collections.web.page.DbMethods;
import org.collections.web.page.FinnAirPage;
import org.collections.web.util.CucumberContainer;
import org.collections.web.util.DbUtil;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;
import java.util.Map;

import static org.collections.web.util.DbUtil.*;
import static org.testng.Assert.assertNotNull;
import static org.web.cucumber.FinnairSteps.finnAirPage;

public class DbSteps {

    private final static String INSERT_BASE = "INSERT INTO FlightDest (CITY_NAME, PRICE) VALUES ('%s', %s)";
    private final static String LOAD_CITY_INFORMATION = "Select CITY_NAME, PRICE from FlightDest where CITY_NAME = '%s'";
    private final static String UPDATE_CITY_PRICE = "UPDATE FlightDest SET PRICE = %s WHERE CITY_NAME = '%s'";
   // Map<String, Float> flights = FinnAirPage.getFlights2;
   // public static FinnAirPage finnAirPage;

    @Given("I pick a random person from DB as {string}")
    public void pickRandomPerson(String alias) {
        PersonDto randomPerson = PersonDto.getRandomPersonFromDB();
        assertNotNull(randomPerson, "Failed to extract random person from DB");

        CucumberContainer.map.put(alias,
                randomPerson.getName().getFirst() + " " + randomPerson.getName().getLast());
    }

    @Then("I store to db new flight to {int} cities or flight with updated prices")
    public  void assertCityPrice(int alias) throws SQLException {
        Map<String, Float> flights = finnAirPage.getFlightsprices(alias);
        SoftAssert softAssert = new SoftAssert();
        for (Map.Entry<String, Float> e : flights.entrySet()) {
            String cityName = e.getKey();
            Float price = e.getValue();

            Map<String, Float> persistenceData = DbUtil.loadPrice(cityName);
            if (!persistenceData.containsKey(cityName)) {
                String insert = String.format(INSERT_BASE, cityName, price);
                DbUtil.storeInDB(insert);
                continue;
            }

            Float persistencePrice = persistenceData.get(cityName);

            if (price.equals(persistencePrice)) {
                continue;
            }

            String update = String.format(UPDATE_CITY_PRICE, cityName, price);
            DbUtil.storeInDB(update);
            softAssert.fail("Price was updated and fail test");
        }
        softAssert.assertAll();
    }
}
