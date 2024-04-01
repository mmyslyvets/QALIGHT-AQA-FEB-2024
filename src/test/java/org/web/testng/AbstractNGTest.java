package org.web.testng;

import lombok.SneakyThrows;
import org.collections.web.driver.WebDriverFactory;
import org.collections.web.page.DbMethods;
import org.collections.web.page.FinnAirPage;
import org.collections.web.page.GooglePage;
import org.collections.web.page.WikiPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


import java.sql.SQLException;

import static org.collections.web.page.DbMethods.connection;

public abstract class AbstractNGTest {

    protected WebDriver driver;
    protected GooglePage googlePage;
    protected WikiPage wikiPage;
    protected FinnAirPage finnAirPage;
    protected DbMethods dbMethods;



    @BeforeSuite
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        googlePage = new GooglePage(driver);
        wikiPage = new WikiPage(driver);
        finnAirPage = new FinnAirPage(driver);
        dbMethods = new DbMethods(driver);
    }

    @SneakyThrows
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
    public void disonnectFromDB() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @BeforeMethod
    public void beforeMethod() throws SQLException, ClassNotFoundException {
        driver.get("about:blank");
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
        try {
            dbMethods.initDBConnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void setUpDB() throws SQLException, ClassNotFoundException {
        dbMethods.initDBConnect();
    }
}
