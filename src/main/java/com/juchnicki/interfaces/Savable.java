package com.juchnicki.interfaces;

import com.juchnicki.model.LocationPojo;
import com.juchnicki.model.Locations;

import java.util.List;

/**
 * Created by Rafal on 2016-09-11.
 */
public interface Savable {
    void save(List<Locations> locationList);
}
