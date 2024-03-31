package org.web.testng;

import lombok.SneakyThrows;
import org.collections.web.driver.WebDriverFactory;
import org.collections.web.page.FinnAirPage;
import org.collections.web.page.GooglePage;
import org.collections.web.page.WikiPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.sql.Connection;

import java.util.concurrent.TimeUnit;

public abstract class AbstractNGTest {

    protected WebDriver driver;
    protected GooglePage googlePage;
    protected WikiPage wikiPage;
    protected FinnAirPage finnAirPage;

    @BeforeSuite
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        googlePage = new GooglePage(driver);
        wikiPage = new WikiPage(driver);
        finnAirPage = new FinnAirPage(driver);
    }

    @SneakyThrows
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("about:blank");
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
    }
}
