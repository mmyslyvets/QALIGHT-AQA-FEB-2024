package org.collections.web.util;

import lombok.SneakyThrows;
import org.collections.web.dto.IConvertible;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {

    private static Connection connection;
    private static Statement statement;

    private final static String INSERT_PERSON =
            "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                    "VALUES ('%s', '%s', '%s', '%s', '%s')";

    private final static String INSERT_FLIGHT =
            "INSERT INTO FlightData (CityName, FlightCost) VALUES ('%s', '%s')";

    @SneakyThrows
    public static void storeInDB(String sql) {
        try {
            getDBConnection();
            statement.execute(sql);
        } catch (Exception e) {
            System.out.println("Failed to execute SQL Query: " + sql);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @SneakyThrows
    public static List<Object> executeSelectStatement(String selectSQL, IConvertible iConvertible) {
        List<Object> results = new ArrayList<>();
        try {
            getDBConnection();
            ResultSet resultSet = statement.executeQuery(selectSQL);
            while (resultSet.next()) {
                results.add(iConvertible.fromResultSet(resultSet));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return results;
    }

    private static void getDBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "user",
                "password"
        );
        statement = connection.createStatement();
    }
}
