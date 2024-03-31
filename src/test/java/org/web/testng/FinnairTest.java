package org.web.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FinnairTest extends AbstractNGTest {

    //TODO 1: add new table flight dest (City name, price tag)
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
        String currentUrl;
        currentUrl = finnAirPage.getCurrentUrl();
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
}
