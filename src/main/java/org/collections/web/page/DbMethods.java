package org.collections.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;


public class DbMethods extends AbstractPage {

    public final static By CITY_NAME = By.xpath("//*[@id=\"search-result-wrapper\"]//a/h3");
    public final static By CITY_PRICE = By.xpath("//*[@id=\"search-result-wrapper\"]//section[2]/a/span");
    private final static String INSERT_BASE = "INSERT INTO FlightDest (CITY_NAME, PRICE) VALUES ('%s', %s)";
    private final static String LOAD_CITY_INFORMATION = "Select CITY_NAME, PRICE from FlightDest where CITY_NAME = '%s'";
    private final static String UPDATE_CITY_PRICE = "UPDATE FlightDest SET PRICE = %s WHERE CITY_NAME = '%s'";
    public final static String FINNAIR_URL = "https://www.finnair.com/us-en";
    public static Connection connection = null;
    public Statement statement = null;

    public DbMethods(WebDriver driver) {

        super(driver, FINNAIR_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public Map<String, Float> getFlights(int limit) {
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