package controllers;

import interfaces.Savable;
import model.LocationDAOImpl;
import model.LocationPOJO;

import java.util.List;

/**
 * Created by Rafal on 2016-09-25.
 */
public class SaveToDatabase implements Savable {
    public void save(List<LocationPOJO> locationPOJOList) {
        LocationDAOImpl locationDAOImpl = new LocationDAOImpl();

        for(LocationPOJO location : locationPOJOList){
            locationDAOImpl.insertLocation(location);
        }
        System.out.println(locationPOJOList.size() + " items inserted successfully.");
    }
}


