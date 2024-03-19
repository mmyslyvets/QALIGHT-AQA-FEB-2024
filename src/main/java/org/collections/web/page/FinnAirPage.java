package org.collections.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FinnAirPage extends AbstractPage {

    private static final String COOKIES_BUTTON_FORM_XPATH = "//*[@id=\"allow-all-btn\"]/span";
    private static final String SEARCH_BUTTON = "//*[@class = 'z0 site-search-expand flex flex--center search-button text-hover']";
    private static final String SEARCH_FIELD = "//div/fin-site-search-header-widget-starter/form/input";
    public final static String FINNAIR_URL = "https://www.finnair.com/us-en";
    public final static String US_ENGLISH_BUTTON = "//a[@aria-label=\"United States, English\"]";
    public final static String LOGIN_Main_BUTTON = "//span[text() = \"Login\"]";
    public final static String USERNAME_FIELD = "//input[@placeholder=\"your@mail.com\"]";
    public final static String PASS_FIELD = "//input[@id=\"pwd\"]";
    public final static String USER_ERROR = "(//div[@class=\"error-label error-900-text font-body-2 ng-star-inserted\"]/span)[1]";

    public final static String PASS_ERROR = "(//div[@class=\"error-label error-900-text font-body-2 ng-star-inserted\"]/span)[last()]";
    public final static String LOGIN_BUTTON = "//*[@class=\"ms-large-t ms-small-b fill-mode\"]";

    public FinnAirPage(WebDriver driver) {
        super(driver, FINNAIR_URL);
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void localSetUp() {
        WebElement enLocal = driver.findElement(By.xpath(US_ENGLISH_BUTTON));
        enLocal.click();
    }

    public void coockieModalClose() {
        WebElement cookieButton = driver.findElement(By.xpath(COOKIES_BUTTON_FORM_XPATH));
        cookieButton.click();
    }

    public void searchAndCheck(String request) {
        WebElement searchButton = driver.findElement(By.xpath(SEARCH_BUTTON));
        searchButton.click();
        WebElement searchField = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_FIELD)));
        searchField.sendKeys(request);

        searchField.sendKeys(Keys.ENTER);
        ExpectedConditions.urlContains("query=" + request);
    }

    public boolean isElementVisible() {
        try {
            WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.presenceOfElementLocated(By.xpath(COOKIES_BUTTON_FORM_XPATH)));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void openLoginModal() {
        WebElement loginMainButton = driver.findElement(By.xpath(LOGIN_Main_BUTTON));
        loginMainButton.click();
    }

    public void loginButtonClick(){
        WebElement loginButton = driver.findElement(By.xpath(LOGIN_BUTTON));
        loginButton.click();
    }

    public void userNameFieldClick() {
        WebElement usernamefield = driver.findElement(By.xpath(USERNAME_FIELD));
        usernamefield.click();
    }

    public String getUserNameError() {
        WebElement usererror = driver.findElement(By.xpath(USER_ERROR));
        return usererror.getText();
    }

    public void passFieldClick() {
        WebElement passfield = driver.findElement(By.xpath(PASS_FIELD));
        passfield.click();
    }

    public String getPassError() {
        WebElement passerror = driver.findElement(By.xpath(PASS_ERROR));
        return passerror.getText();
    }


}
