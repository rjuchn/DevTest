package utils;

/**
 * Created by Rafal on 2016-09-25.
 */
public class LocationPOJO {
    private int id;
    private String name;
    private String type;
    private int geo_latitude;
    private int geo_longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGeo_latitude() {
        return geo_latitude;
    }

    public void setGeo_latitude(int geo_latitude) {
        this.geo_latitude = geo_latitude;
    }

    public int getGeo_longitude() {
        return geo_longitude;
    }

    public void setGeo_longitude(int geo_longitude) {
        this.geo_longitude = geo_longitude;
    }
}
