package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Rafal on 2016-09-29.
 */
@Component
public class LocationDAO {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate = getJdbcTemplate();

    public void insertLocation(LocationPOJO location){
        String sql = "insert into locations (geo_id, geo_name, geo_type, geo_longitude, geo_latitude) values (?, ?, ?, ?, ?)";

        jdbcTemplate.setDataSource(getDataSource());
        jdbcTemplate.update(sql, new Object[] {
                location.getId().intValue(),
                location.getName().toString(),
                location.getType().toString(),
                String.valueOf(location.getGeo_latitude()),
                String.valueOf(location.getGeo_longitude())});
    }

    private DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
