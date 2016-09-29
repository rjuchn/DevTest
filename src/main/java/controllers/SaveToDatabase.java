package controllers;

import interfaces.Savable;
import model.LocationDAO;
import model.LocationPOJO;

import java.util.List;

/**
 * Created by Rafal on 2016-09-25.
 */
public class SaveToDatabase implements Savable {
    public void save(List<LocationPOJO> locationPOJOList) {
        LocationDAO locationDAO = new LocationDAO();

        for(LocationPOJO location : locationPOJOList){
            locationDAO.insertLocation(location);
        }
        System.out.println(locationPOJOList.size() + " items inserted successfully.");
    }
}


