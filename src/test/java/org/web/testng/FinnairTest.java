package org.web.testng;

import org.collections.web.page.FinnAirPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;

public class FinnairTest extends AbstractNGTest {

    // TODO 1: add new table flight dest (City name, price tag)
    // TODO 2: open https://www.finnair.com/en/destinations?country=fi
    // TODO 3: tae four top destinations and for each:
    // TODO 3.1: If record for this dest is already in DB, compare price.
    //  If price has changed: update price and fail test
    //  If price did not change - test passes.
    // TODO 3.2: If record for this dest is not present, store it, test passes

    @Test
    public void myGoogleTest1() {
        System.out.println("my finnair ng 1");
    }

    @Test
    public void myGoogleTest2() {
        System.out.println("my finnair ng 2");
    }

    @Test
    public void myGoogleTest3() {
        System.out.println("my finnair ng 3");
    }

    @Test
    public void testSearchResultWithCondition() {
        googlePage.setSearchText("finnair");
        googlePage.feelingLucky();
        finnAirPage.localSetUp();
        if (finnAirPage.isElementVisible()) {
            finnAirPage.coockieModalClose();
        }
        finnAirPage.search("barcelona");
        finnAirPage.searcResultsCheck();
        String currentUrl = finnAirPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("barcelona"),
                "Expected to be at barcelona, but was at " + currentUrl);
    }

    @Test
    public void testLoginErrors() {
        googlePage.setSearchText("finnair");
        googlePage.feelingLucky();
        finnAirPage.localSetUp();
        if (finnAirPage.isElementVisible()) {
            finnAirPage.coockieModalClose();
        }
        finnAirPage.openLoginModal();
        finnAirPage.userNameFieldClick();
        finnAirPage.loginButtonClick();
        finnAirPage.passFieldClick();
        finnAirPage.loginButtonClick();
        String nameerror;
        String paserror;
        nameerror = finnAirPage.getUserNameError();
        paserror = finnAirPage.getPassError();
        Assert.assertTrue(nameerror.contains("Email address or Finnair Plus number is required"), "Expected to be Email address or Finnair Plus number is required, but was a" + paserror);
        Assert.assertTrue(paserror.contains("Password is required"), "Expected Password is required, but was a" + paserror);
    }


    @Test
    public void checkAndSaveDest_update() throws SQLException {
        googlePage.setSearchText("finnair");
        googlePage.feelingLucky();
        finnAirPage.localSetUp();
        if (finnAirPage.isElementVisible()) {
            finnAirPage.coockieModalClose();
        }
        finnAirPage.openFinlandDestination();

        Map<String, Float> flights = dbMethods.getFlights(4);
        assertCityPrice(flights);

    }

    private void assertCityPrice(Map<String, Float> flights) throws SQLException {
        SoftAssert softAssert = new SoftAssert();
        for (Map.Entry<String, Float> e : flights.entrySet()) {
            String cityName = e.getKey();
            Float price = e.getValue();

            Map<String, Float> persistenceData = dbMethods.loadPrice(cityName);
            if (!persistenceData.containsKey(cityName)) {
                dbMethods.insertToDb(cityName, price);
                continue;
            }

            Float persistencePrice = persistenceData.get(cityName);

            if (price.equals(persistencePrice)) {
                continue;
            }

            dbMethods.updateCity(cityName, price);
            softAssert.fail("Price was updated and fail test");
        }
        softAssert.assertAll();
    }
}
