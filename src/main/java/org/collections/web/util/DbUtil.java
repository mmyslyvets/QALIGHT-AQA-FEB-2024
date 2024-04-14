package org.collections.web.util;

import lombok.SneakyThrows;
import org.collections.web.dto.IConvertible;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class DbUtil {

    private final static String ENV_TYPE = System.getProperty("driver.type", "CHROME");
    private final static String ENV_TYPE_JENKINS = "JENKINS";

    private static Connection connection;
    private static Statement statement;

    private final static String INSERT_PERSON =
            "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                    "VALUES ('%s', '%s', '%s', '%s', '%s')";

    private final static String INSERT_FLIGHT =
            "INSERT INTO FlightData (CityName, FlightCost) VALUES ('%s', '%s')";

    private final static String LOAD_CITY_INFORMATION = "Select CITY_NAME, PRICE from FlightDest where CITY_NAME = '%s'";

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
        String hostName;

        if (ENV_TYPE_JENKINS.equals(ENV_TYPE)) {
            hostName = "jdbc:mysql://mysql-db-1:3306/db";
        } else {
            hostName = "jdbc:mysql://localhost:3306/db";
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                hostName,
                "user",
                "password"
        );
        statement = connection.createStatement();
    }

    public static Map<String, Float> loadPrice(String city) throws SQLException {
        Map<String, Float> dbData = new HashMap<>();
        try {
            getDBConnection();
        ResultSet resultSet = statement.executeQuery(format(LOAD_CITY_INFORMATION, city));

        while (resultSet.next()) {
            String cityName = resultSet.getString("CITY_NAME");
            Float price = resultSet.getFloat("PRICE");
            dbData.put(cityName, price);
        }
        }catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }

        return dbData;
    }
}
