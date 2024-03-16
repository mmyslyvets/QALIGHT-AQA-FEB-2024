package org.web.testng;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleTest extends AbstractNGTest {

    @Test
    public void googleRegularSearchTest() {
        String expectedName = "Ben Affleck";
        googlePage.setSearchText("Ben Affleck");

        googlePage.performSearch();
        List<WebElement> searchHeaders = googlePage.getSearchHeaders();
        boolean benFound = false;
        for (WebElement e : searchHeaders) {
            if (e.getText().contains(expectedName)) {
                benFound = true;
                break;
            }
        }

        Assert.assertTrue(benFound,
                "Ben Affleck not found while searching for " + expectedName);
    }

    @Test
    public void googleLuckySearchTest() {
        googlePage.setSearchText("Ben Affleck");
        googlePage.feelingLucky();
        String currentUrl;

        currentUrl = wikiPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("wiki"),
                "Expected to be at wikipedia, but was at " + currentUrl);

        wikiPage.navigateBack();

        currentUrl = googlePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("google"),
                "Expected to be at google, but was at " + currentUrl);
    }
}
