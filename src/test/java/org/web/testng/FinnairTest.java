package org.web.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FinnairTest extends AbstractNGTest {

    //TODO: OPTIONAL
    //TODO: Move Finnair test to testNG
    //TODO: Open finnair page through google
    //TODO: Add assertions

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
        finnAirPage.searchAndCheck("barcelona");
        String currentUrl;
        currentUrl = finnAirPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("barcelona"),
                "Expected to be at barcelona, but was at " + currentUrl);
    }

    @Test
    public void testLoginErrors(){
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
