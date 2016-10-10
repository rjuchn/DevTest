package com.juchnicki.model;

import com.juchnicki.interfaces.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@Qualifier("JDBC")
public class LocationDaoImpl implements LocationDao { // extract interface!

    public static final String INSERT = "insert into locations (geo_id, geo_name, geo_type, geo_longitude, geo_latitude) values (?, ?, ?, ?, ?)";
    public static final String FIND_BY_ID = "SELECT * FROM locations where GEO_ID = ?";

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(Locations location) {

        getJdbcTemplate().update(INSERT, new Object[]{
                location.getId().intValue(),
                location.getName().toString(),
                location.getType().toString(),
                String.valueOf(location.getGeo_latitude()),
                String.valueOf(location.getGeo_longitude())});
    }

    public LocationPojo getLocation(int locationId) {
        return jdbcTemplate.queryForObject(FIND_BY_ID, new LocationMapper(), locationId);
    }

    private DataSource getDataSource() {
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            throw new IllegalStateException("jdbcTemplate cannot be null");
        }
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Inner class for rowMapper implementation
    private static final class LocationMapper implements RowMapper<LocationPojo> {

        public LocationPojo mapRow(ResultSet resultSet, int i) throws SQLException {
            LocationPojo locationPOJO = new LocationPojo();
            locationPOJO.setId(resultSet.getLong("GEO_ID"));
            locationPOJO.setName(resultSet.getString("GEO_NAME"));
            locationPOJO.setType(resultSet.getString("GEO_TYPE"));
            locationPOJO.setGeo_latitude(resultSet.getLong("GEO_LATITUDE"));
            locationPOJO.setGeo_longitude(resultSet.getLong("GEO_LONGITUDE"));
            return locationPOJO;
        }
    }
}