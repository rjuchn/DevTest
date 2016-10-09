package com.juchnicki.interfaces;

import com.juchnicki.model.LocationPojo;

/**
 * Created by Rafal on 2016-10-09.
 */
public interface LocationDao {
    void save(LocationPojo location);

    LocationPojo getLocation(int locationId);
}
