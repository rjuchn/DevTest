package com.juchnicki.interfaces;

import com.juchnicki.model.LocationPojo;
import com.juchnicki.model.Locations;

/**
 * Created by Rafal on 2016-10-09.
 */
public interface LocationDao {
    void save(Locations location);

    LocationPojo getLocation(int locationId);
}
