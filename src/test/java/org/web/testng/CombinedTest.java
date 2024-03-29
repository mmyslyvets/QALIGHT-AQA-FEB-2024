package org.web.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import org.collections.web.dto.PersonDto;
import org.collections.web.dto.ResultsDto;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
        List<PersonDto> personDtos = getRandomPerson(2);
        for (PersonDto dto : personDtos) {
            storeInDb(dto);
        }
    }

//    FirstName, LastName, Gender, Title, Nat
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
