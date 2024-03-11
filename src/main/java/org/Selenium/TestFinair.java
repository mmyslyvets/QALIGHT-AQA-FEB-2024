package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestFinair {

    private static final String COOKIES_BUTTON_FORM_XPATH = "//*[@id=\"allow-all-btn\"]/span";
    private static final String SEARCH_BUTTON = "//*[@class = 'z0 site-search-expand flex flex--center search-button text-hover']";
    //private static final String SEARCH_BUTTON = "search";
    private static final String SEARCH_FIELD = "//div/fin-site-search-header-widget-starter/form/input";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            driver.get("https://www.finnair.com/en");
            List<WebElement> cookieButtons = driver.findElements(By.xpath(COOKIES_BUTTON_FORM_XPATH));
            if (!cookieButtons.isEmpty()) {
                cookieButtons.get(0).click();
            }
            WebElement searchButton = driver.findElement(By.xpath(SEARCH_BUTTON));
            searchButton.click();
            WebElement searchField = driver.findElement(By.xpath(SEARCH_FIELD));
            searchField.sendKeys("Barcelona");
            searchField.sendKeys(Keys.ENTER);
            ExpectedConditions.urlContains("query=barcelona");
        } finally {
            driver.quit();
        }
    }
}
