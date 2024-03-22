package org.web.testng;

import org.collections.web.driver.WebDriverFactory;
import org.collections.web.page.GooglePage;
import org.collections.web.page.WikiPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class AbstractNGTest {

    protected WebDriver driver;
    protected GooglePage googlePage;
    protected WikiPage wikiPage;

    @BeforeSuite
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        googlePage = new GooglePage(driver);
        wikiPage = new WikiPage(driver);
    }

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
