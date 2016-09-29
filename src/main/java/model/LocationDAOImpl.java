package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rafal on 2016-09-29.
 */
@Component
public class LocationDAOImpl {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void insertLocation(LocationPOJO location){
        String sql = "insert into locations (geo_id, geo_name, geo_type, geo_longitude, geo_latitude) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, new Object[] {
                location.getId().intValue(),
                location.getName().toString(),
                location.getType().toString(),
                String.valueOf(location.getGeo_latitude()),
                String.valueOf(location.getGeo_longitude())});
    }

    public LocationPOJO getLocation(int locationId){
        String sql = "SELECT * FROM locations where GEO_ID = ?";
        return jdbcTemplate.queryForObject(sql, new LocationMapper(), locationId);
    }

    private DataSource getDataSource() {
        return dataSource;
    }

    // assigning datasource directly to jdbcTemplate in a setter because there is no need to use datasource standalone
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Inner class for rowMapper implementation
    private static final class LocationMapper implements RowMapper<LocationPOJO> {

        public LocationPOJO mapRow(ResultSet resultSet, int i) throws SQLException {
            LocationPOJO locationPOJO = new LocationPOJO();
            locationPOJO.setId(resultSet.getLong("GEO_ID"));
            locationPOJO.setName(resultSet.getString("GEO_NAME"));
            locationPOJO.setType(resultSet.getString("GEO_TYPE"));
            locationPOJO.setGeo_latitude(resultSet.getLong("GEO_LATITUDE"));
            locationPOJO.setGeo_longitude(resultSet.getLong("GEO_LONGITUDE"));
            return locationPOJO;
        }
    }
}
