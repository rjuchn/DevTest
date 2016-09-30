package controllers;

import interfaces.Savable;
import model.LocationDaoImpl;
import model.LocationPojo;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Rafal on 2016-09-25.
 */
@Controller
public class SaveToDatabase implements Savable {
    private LocationDaoImpl locationDaoImpl = new LocationDaoImpl();

    public void save(List<LocationPojo> locationPojoList) {

        for(LocationPojo location : locationPojoList){
            locationDaoImpl.insertLocation(location);
        }
        System.out.println(locationPojoList.size() + " items inserted successfully.");
    }
}


