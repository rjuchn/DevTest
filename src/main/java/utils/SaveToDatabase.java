package utils;

import interfaces.Savable;

import java.sql.*;
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

            PreparedStatement locationInsertStatement;
            for(LocationPOJO location : locationPOJOList){
                /* Here using Statement class and executing prepared query */
//                String executableSQL = "insert into locations (geo_id, geo_name, geo_type, geo_longitude, geo_latitude) values (" +
//                        location.getId().intValue() + ", " +
//                        "'" + location.getName().toString() + "', " +
//                        "'" + location.getType().toString() + "', " +
//                        "'" + location.getGeo_latitude() + "', " +
//                        "'" + location.getGeo_longitude() + "')";

                /* using PreparedStatement class and inject parameters to statement */
                locationInsertStatement = connection.prepareStatement("insert into locations (geo_id, geo_name, geo_type, geo_longitude, geo_latitude) values (?, ?, ?, ?, ?)");

                locationInsertStatement.setInt(1, location.getId().intValue());
                locationInsertStatement.setString(2, location.getName().toString());
                locationInsertStatement.setString(3, location.getType().toString());
                locationInsertStatement.setString(4, String.valueOf(location.getGeo_latitude()));
                locationInsertStatement.setString(5, String.valueOf(location.getGeo_longitude()));

                locationInsertStatement.executeQuery();
               // System.out.println(executableSQL);
            }

            System.out.println(locationPOJOList.size() + " items inserted successfully.");

        } catch(SQLIntegrityConstraintViolationException e) {
            System.out.println("There are already records with current id. Application terminated.");
            e.printStackTrace();
            return;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }
}


