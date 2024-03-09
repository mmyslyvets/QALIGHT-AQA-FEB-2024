package org.collections.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumDemo {

    private static final String COOKIES_FORM_XPATH =
            "//a[contains(@href,'https://policies.google.com/technologies/cookies')]/../../../..//button";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://google.com/");
            List<WebElement> cookieButtons = driver.findElements(By.xpath(COOKIES_FORM_XPATH));
            if (!cookieButtons.isEmpty()) {
                cookieButtons.get(3).click();
            }
            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.sendKeys("Ben Affleck");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> searchHeaders = new WebDriverWait(driver, Duration.ofSeconds(5L))
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a/h3"), 2));

            for (WebElement e : searchHeaders) {
                if (e.getText().contains("Ben Affleck")) {
                    System.out.println("Ben found!");
                    break;
                }
            }
//            ExpectedConditions.visibilityOfElementLocated()
//            ExpectedConditions.urlToBe()
            //TODO: got to finnair, accept cookies, search for barcelona, confirm url is https://www.finnair.com/en/search?query=Bacelon
        } finally {
            driver.quit();
        }
    }
}
