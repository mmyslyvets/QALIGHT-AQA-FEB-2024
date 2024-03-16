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

//    @BeforeTest
//    public void beforeEachTestPack() {
//        System.out.println("Starting test package....");
//    }
//
//    @AfterTest
//    public void afterEachTestPack() {
//        System.out.println("Ending test package....");
//    }
//
//    @BeforeClass
//    public void beforeEachClass() {
//        System.out.println("-----------------------");
//    }
//
//    @AfterClass
//    public void afterEachClass() {
//        System.out.println("########################");
//    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("about:blank");
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
    }

//    @AfterMethod
//    public void afterMethod() {
//    }
}
