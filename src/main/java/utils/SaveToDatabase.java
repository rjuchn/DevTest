package utils;

import interfaces.Savable;
import model.LocationPOJO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rafal on 2016-09-25.
 */
public class SaveToDatabase implements Savable {

    @Autowired
    private DataSource dataSource;

    public void save(List<LocationPOJO> locationPOJOList) {

        Connection connection = null;

        try {
            connection = dataSource.getConnection();

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

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}


