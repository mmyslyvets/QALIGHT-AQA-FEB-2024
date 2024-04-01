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
    public final static By CITY_NAME = By.xpath("//*[@id=\"search-result-wrapper\"]/fin-destination-search-results-item/fin-block-offer-tile/section/div/section[2]/a/h3");
    public final static By CITY_PRICE = By.xpath("//*[@id=\"search-result-wrapper\"]/fin-destination-search-results-item/fin-block-offer-tile/section/div/section[2]/a/span");
    private final static String INSERT_BASE = "INSERT INTO FlightDest (CITY_NAME, PRICE) VALUES ('%s', %s)";
    private final static String LOAD_CITY_INFORMATION = "Select CITY_NAME, PRICE from FlightDest where CITY_NAME = '%s'";
    private final static String UPDATE_CITY_PRICE = "UPDATE FlightDest SET PRICE = %s WHERE CITY_NAME = '%s'";
    public static Connection connection = null;
    public Statement statement = null;


    public FinnAirPage(WebDriver driver) {
        super(driver, FINNAIR_URL);
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
            WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.presenceOfElementLocated(COOKIES_BUTTON_FORM_XPATH));
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

//    public Map<String, String> getDest(int count) {
//        List<WebElement> cityName = (List<WebElement>) driver.findElements(CITY_NAME);
//        List<WebElement> cityPrice = (List<WebElement>) driver.findElements(CITY_PRICE);
//        Map<String, String> cities_prices = new HashMap<>();
//        for (int i = 1; i <= count; i++) {
//            //cities_prices.put(cityName.get(i).getText(), Integer.parseInt(cityPrice.get(i).getText().split(" USD"));
//            //Integer.parseInt(cityPrice.get(i).getText().split(" ").get(0)
//            //cityPrice.get(i).getText() -> "123 USD"
//            //cityPrice.get(i).getText().split(" USD") -> String["123"]
//        }
//        return cities_prices;
//
//    }

    public Map<String, Float> getFlights(int limit) {
        List<WebElement> cityNames = driver.findElements(CITY_NAME);
        List<WebElement> prices = driver.findElements(CITY_PRICE);

        // TODO: create FinAirData class (cityName, price)
        Map<String, Float> data = new HashMap<>();
        for (int idx = 0; idx < limit; idx++) {
            String cityName = cityNames.get(idx).getText();

            String rawPrice = prices.get(idx).getText().split(" ")[0];
            Float price = Float.parseFloat(rawPrice);

            data.put(cityName, price);
        }

        return data;
    }

    public void initDBConnect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "user",
                "password"
        );
        statement = connection.createStatement();
    }


    public void saveToDB(Map<String, Float> flights) throws SQLException {
        for (Map.Entry<String, Float> e : flights.entrySet()) {
            String cityName = e.getKey();
            Float price = e.getValue();

            insertToDb(cityName, price);
        }
    }

    public void insertToDb(String cityName, Float price) throws SQLException {
        String sql = format(INSERT_BASE, cityName, price);
        statement.execute(sql);
    }


    public Map<String, Float> loadPrice(String city) throws SQLException {
        ResultSet resultSet = statement.executeQuery(format(LOAD_CITY_INFORMATION, city));
        Map<String, Float> dbData = new HashMap<>();
        while (resultSet.next()) {
            String cityName = resultSet.getString("CITY_NAME");
            Float price = resultSet.getFloat("PRICE");
            dbData.put(cityName, price);
        }

        return dbData;
    }


    public void updateCity(String cityName, Float price) throws SQLException {
        String sql = format(UPDATE_CITY_PRICE, price, cityName);
        statement.execute(sql);
    }
}
