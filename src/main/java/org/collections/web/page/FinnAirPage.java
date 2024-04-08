package org.collections.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.sql.*;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;


public class FinnAirPage extends AbstractPage {

    private static final By COOKIES_BUTTON_FORM_XPATH = By.xpath("//*[@id=\"allow-all-btn\"]/span");
    private static final By SEARCH_BUTTON = By.xpath("//*[@class = 'z0 site-search-expand flex flex--center search-button text-hover']");
    private static final By SEARCH_FIELD = By.xpath("//div/fin-site-search-header-widget-starter/form/input");
    public final static String FINNAIR_URL = "https://www.finnair.com/us-en";
    public final static By US_ENGLISH_BUTTON = By.xpath("//a[@aria-label=\"United States, English\"]");
    public final static By LOGIN_Main_BUTTON = By.xpath("//span[text() = \"Login\"]");
    public final static By USERNAME_FIELD = By.xpath("//input[@placeholder=\"your@mail.com\"]");
    public final static By PASS_FIELD = By.xpath("//input[@id=\"pwd\"]");
    public final static By USER_ERROR = By.xpath("(//div[@class=\"error-label error-900-text font-body-2 ng-star-inserted\"]/span)[1]");
    public final static By PASS_ERROR = By.xpath("(//div[@class=\"error-label error-900-text font-body-2 ng-star-inserted\"]/span)[last()]");
    public final static By LOGIN_BUTTON = By.xpath("//*[@class=\"ms-large-t ms-small-b fill-mode\"]");
    public final static By SEARCH_RESULTS = By.xpath("//a/div/em");
    public final static By MENU_BUTTON = By.xpath("//*[text() = 'Menu']");
    public final static By FINLAND_BUTTON = By.xpath("//*[text() = ' Finland ']");
    public final static By DEST_BUTTON = By.xpath("//*[text() = ' Destinations & offers ']");
    public final static By CITY_NAME = By.xpath("//*[@id=\"search-result-wrapper\"]//a/h3");
    public final static By CITY_PRICE = By.xpath("//*[@id=\"search-result-wrapper\"]//section[2]/a/span");
    public static Map<String, Float> getFlights2;


    public FinnAirPage(WebDriver driver) {
        super(driver, FINNAIR_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void localSetUp() {
        WebElement enLocal = driver.findElement(US_ENGLISH_BUTTON);
        enLocal.click();
    }

    public void coockieModalClose() {
        WebElement cookieButton = driver.findElement(COOKIES_BUTTON_FORM_XPATH);
        cookieButton.click();
    }

    public void search(String request) {
        WebElement searchButton = driver.findElement(SEARCH_BUTTON);
        searchButton.click();
        WebElement searchField = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD));
        searchField.sendKeys(request);
        searchField.sendKeys(Keys.ENTER);
    }

    public void searcResultsCheck() {
        // List<WebElement> searchResults = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfElementsToBeMoreThan(SEARCH_RESULTS, 2));
        WebElement searchResults = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(SEARCH_RESULTS));
    }

    public boolean isElementVisible() {
        try {
            WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(30))).until(ExpectedConditions.presenceOfElementLocated(COOKIES_BUTTON_FORM_XPATH));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void openLoginModal() {
        WebElement loginMainButton = driver.findElement(LOGIN_Main_BUTTON);
        loginMainButton.click();
    }

    public void loginButtonClick() {
        WebElement loginButton = driver.findElement(LOGIN_BUTTON);
        loginButton.click();
    }

    public void userNameFieldClick() {
        WebElement usernamefield = driver.findElement(USERNAME_FIELD);
        usernamefield.click();
    }

    public String getUserNameError() {
        WebElement usererror = driver.findElement(USER_ERROR);
        return usererror.getText();
    }

    public void passFieldClick() {
        WebElement passfield = driver.findElement(PASS_FIELD);
        passfield.click();
    }

    public String getPassError() {
        WebElement passerror = driver.findElement(PASS_ERROR);
        return passerror.getText();
    }

    public void openFinlandDestination() {
        WebElement menu = driver.findElement(MENU_BUTTON);
        menu.click();
        WebElement destButton = driver.findElement(DEST_BUTTON);
        destButton.click();
        WebElement finlandDest = driver.findElement(FINLAND_BUTTON);
        finlandDest.click();
    }

    public Map<String, Float> getFlightsprices(int limit) {
        List<WebElement> cityNames = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(CITY_NAME));
        List<WebElement> prices = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(CITY_PRICE));


        Map<String, Float> data = new HashMap<>();
        for (int idx = 0; idx < limit; idx++) {
            String cityName = cityNames.get(idx).getText();

            String rawPrice = prices.get(idx).getText().split(" ")[0];
            Float price = Float.parseFloat(rawPrice);

            data.put(cityName, price);
        }

        return data;
    }

}
