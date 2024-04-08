package org.web.cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.SneakyThrows;
import org.collections.web.driver.WebDriverFactory;
import org.collections.web.page.FinnAirPage;
import org.collections.web.page.GooglePage;
import org.collections.web.page.WikiPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
//        tags = "@my-new-test",
        features = "src/test/resources/features",
        glue = "org.web.cucumber",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        MySteps.googlePage = new GooglePage(driver);
        FinnairSteps.finnAirPage = new FinnAirPage(driver);
    }

    @SneakyThrows
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
