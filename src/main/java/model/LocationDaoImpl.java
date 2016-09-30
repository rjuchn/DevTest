package model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rafal on 2016-09-29.
 */
@Component
public class LocationDaoImpl extends JdbcDaoSupport{

    /* Now I just extend JdbcDaoSupport form spring so I commented out previous code*/
//    private DataSource dataSource;
//
//    private JdbcTemplate jdbcTemplate;
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    private DataSource getDataSource() {
//        return dataSource;
//    }
//
//    // assigning datasource directly to jdbcTemplate in a setter because there is no need to use datasource standalone
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//    }
//
//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
//        return namedParameterJdbcTemplate;
//    }
//
//    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//    }
    /* Using named parameter */
//    public void insertLocation(LocationPojo location){
//        String sql = "insert into locations (geo_id, geo_name, geo_type, geo_longitude, geo_latitude) values (:id, :name, :type, :latitude, :longitude)";
//        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", location.getId())
//                .addValue("name", location.getName())
//                .addValue("type", location.getType())
//                .addValue("latitude", location.getGeo_latitude())
//                .addValue("longitude", location.getGeo_longitude());
//
//        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
//    }

    private JdbcTemplate jdbcTemplate = this.getJdbcTemplate();

    /* jdbcTamplate version */
    public void insertLocation(LocationPojo location){
        String sql = "insert into locations (geo_id, geo_name, geo_type, geo_longitude, geo_latitude) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, new Object[] {
                location.getId().longValue(),
                location.getName().toString(),
                location.getType().toString(),
                Double.valueOf(location.getGeo_latitude()),
                Double.valueOf(location.getGeo_longitude())});
    }

    public LocationPojo getLocation(int locationId){
        String sql = "SELECT * FROM locations where GEO_ID = ?";
        return jdbcTemplate.queryForObject(sql, new LocationMapper(), locationId);
    }

    // Inner class for rowMapper implementation
    private static final class LocationMapper implements RowMapper<LocationPojo> {

        public LocationPojo mapRow(ResultSet resultSet, int i) throws SQLException {
            LocationPojo locationPojo = new LocationPojo();
            locationPojo.setId(resultSet.getLong("GEO_ID"));
            locationPojo.setName(resultSet.getString("GEO_NAME"));
            locationPojo.setType(resultSet.getString("GEO_TYPE"));
            locationPojo.setGeo_latitude(resultSet.getLong("GEO_LATITUDE"));
            locationPojo.setGeo_longitude(resultSet.getLong("GEO_LONGITUDE"));
            return locationPojo;
        }
    }
}
