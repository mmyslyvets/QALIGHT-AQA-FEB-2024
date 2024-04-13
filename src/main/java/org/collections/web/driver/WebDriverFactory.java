package org.collections.web.driver;

import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class WebDriverFactory {

    @SneakyThrows
    public static WebDriver getDriver() {
        String driverTypeFromProps = System.getProperty("driver.type", "CHROME");

        switch (driverTypeFromProps) {
            case "JENKINS":
                return new RemoteWebDriver(
                        new URL("http://selenoid-selenoid-1:4444/wd/hub"), remoteOptions());
            case "REMOTE":
                return new RemoteWebDriver(
                        new URL("http://localhost:4444/wd/hub"), remoteOptions());
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

    private static Capabilities remoteOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
            put("enableVNC", true);
        }});
        return options;
    }
}
