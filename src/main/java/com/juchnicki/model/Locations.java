package com.juchnicki.model;

/**
 * Created by Rafal on 2016-10-10.
 */
public interface Locations {
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    String getType();

    void setType(String type);

    double getGeo_latitude();

    void setGeo_latitude(double geo_latitude);

    double getGeo_longitude();

    void setGeo_longitude(double geo_longitude);
}
