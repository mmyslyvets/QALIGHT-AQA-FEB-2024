package org.web.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import org.collections.web.dto.PersonDto;
import org.collections.web.dto.ResultsDto;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class CombinedTest extends AbstractNGTest {

    private final static String INSERT_BASE =
            "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                    "VALUES ('%s', '%s', '%s', '%s', '%s')";

    private Connection connection = null;
    private Statement statement = null;

    @SneakyThrows
    @BeforeMethod
    public void setUpDB() {
        getDBConnection();
    }

    @SneakyThrows
    @AfterMethod
    public void disonnectFromDB() {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void getAndStorePerson() {
        getRandomPerson(2).forEach(p -> storeInDb(p));
        Optional<String> randomPerson = pickRandomPersonFromDB();

        if (randomPerson.isEmpty()) {
            Assert.fail("Could not extract random person from DB");
        }

        googlePage.setSearchText(randomPerson.get());
        googlePage.performSearch();
        Assert.assertTrue(
                googlePage.getSearchHeaders()
                        .stream()
                        .anyMatch(
                                we -> we.getText().toUpperCase().contains(randomPerson.get().toUpperCase())
                        ), "No person with this name found! " + randomPerson.get()
        );
    }

    private Optional<String> pickRandomPersonFromDB() {
        Optional<String> result = Optional.empty();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons ORDER BY RAND() LIMIT 1");
            while (resultSet.next()) {
                result = Optional.ofNullable(String.format("%s %s",
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName")));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private void storeInDb(PersonDto dto) {
        try {
            statement.execute(String.format(INSERT_BASE,
                    dto.getName().getFirst(),
                    dto.getName().getLast(),
                    dto.getGender(),
                    dto.getName().getTitle(),
                    dto.getNat()));
        } catch (SQLException e) {
            System.out.println("Failed to save user, but we continue!");
        }
    }

    private List<PersonDto> getRandomPerson(int amount) {
        RestAssured.baseURI = "https://randomuser.me/";
        return RestAssured.given()
                .basePath("/api")
                .queryParam("inc", "gender,name,nat")
                .queryParam("noinfo")
                .queryParam("results", amount)
                .get()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .as(ResultsDto.class)
                .getResults();
    }

    private void getDBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "user",
                "password"
        );
        statement = connection.createStatement();
    }
}
