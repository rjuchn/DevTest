package utils;

import interfaces.Savable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Rafal on 2016-09-25.
 */
public class SaveToDatabase implements Savable {

    private String dbAdress = "jdbc:oracle:thin:@localhost:1521:rafaldb";
    private String user = "app_client";
    private String uPass = "rafafal";

    public void save(String stringToBeSaved) {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(dbAdress, user, uPass);

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}


