package org.collections.web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver() {
        String driverType = System.getenv().get("driver.type");
        switch (driverType) {
            case "EDGE":
                return new EdgeDriver();
            case "FIREFOX":
                return new FirefoxDriver();
            default:
                return new ChromeDriver(chromeOptions());
        }
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--start-maximized");
        return options;
    }
}
