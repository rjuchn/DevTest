package com.juchnicki.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Rafal on 2016-10-09.
 */
@Entity
public class LocationHibernate {
    @Id
    private Long id;
    private String name;
    private String type;
    private double geo_latitude;
    private double geo_longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getGeo_latitude() {
        return geo_latitude;
    }

    public void setGeo_latitude(double geo_latitude) {
        this.geo_latitude = geo_latitude;
    }

    public double getGeo_longitude() {
        return geo_longitude;
    }

    public void setGeo_longitude(double geo_longitude) {
        this.geo_longitude = geo_longitude;
    }
}
