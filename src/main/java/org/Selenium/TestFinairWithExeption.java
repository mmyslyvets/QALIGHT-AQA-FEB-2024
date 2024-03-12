package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestFinairWithExeption {

    private static final String COOKIES_BUTTON_FORM_XPATH = "//*[@id=\"allow-all-btn\"]/span";
    private static final String SEARCH_BUTTON = "//*[@class = 'z0 site-search-expand flex flex--center search-button text-hover']";
    private static final String SEARCH_FIELD = "//div/fin-site-search-header-widget-starter/form/input";

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
      //  testSearchResult("https://www.finnair.com/en", "barcelona");
        testSearchResultWithCondition("https://www.finnair.com/en", "barcelona", COOKIES_BUTTON_FORM_XPATH);
    }


    public static void waitimp() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    public static void coockieModalClose() {
        waitimp();
        WebElement cookieButton = driver.findElement(By.xpath(COOKIES_BUTTON_FORM_XPATH));
        cookieButton.click();
    }

    public static void searchAndCheck(String request) {
        waitimp();
        WebElement searchButton = driver.findElement(By.xpath(SEARCH_BUTTON));
        searchButton.click();
        WebElement searchField = driver.findElement(By.xpath(SEARCH_FIELD));
        searchField.sendKeys(request);
        searchField.sendKeys(Keys.ENTER);
        ExpectedConditions.urlContains("query=" + request);
    }

    public static boolean isElementVisible(String path) {
          try {
            WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static void testSearchResult(String link, String request, String path) {
        driver.get(link);
        try {
            coockieModalClose();
            searchAndCheck(request);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            searchAndCheck(request);
        } finally {
            driver.quit();
        }
    }


    public static void testSearchResultWithCondition(String link, String request, String path) {
        driver.get(link);
        try {
            if (isElementVisible(path)) {
                coockieModalClose();
                searchAndCheck(request);
            }
            searchAndCheck(request);
        } finally {
            driver.quit();
        }
    }
}