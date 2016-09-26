package utils;

import interfaces.Savable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Rafal on 2016-09-25.
 */
public class SaveToDatabase implements Savable {

    private String dbAdress = "jdbc:oracle:thin:@localhost:1521:rafaldb";
    private String user = "app_client";
    private String uPass = "rafafal";

    public void save(List<LocationPOJO> locationPOJOList) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(dbAdress, user, uPass);

            Statement locationInsertStatement = connection.createStatement();
            for(LocationPOJO location : locationPOJOList){
                String executableSQL = "insert into locations (geo_id, geo_name, geo_type, geo_longitude, geo_latitude) values (" +
                        location.getId().intValue() + ", " +
                        "'" + location.getName().toString() + "', " +
                        "'" + location.getType().toString() + "', " +
                        "'" + location.getGeo_latitude() + "', " +
                        "'" + location.getGeo_longitude() + "')";

                locationInsertStatement.executeUpdate(executableSQL);
               // System.out.println(executableSQL);
            }

            System.out.println(locationPOJOList.size() + " items inserted successfully.");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }
}


