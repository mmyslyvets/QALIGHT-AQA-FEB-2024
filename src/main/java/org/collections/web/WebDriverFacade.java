package org.collections.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverFacade {

    private final WebDriver driver;

    public WebDriverFacade(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
