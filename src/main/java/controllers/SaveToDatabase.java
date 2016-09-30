package controllers;

import data.Constants;
import interfaces.Savable;
import model.LocationDAOImpl;
import model.LocationPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Rafal on 2016-09-25.
 */
@Component
@Qualifier( Constants.STRATEGY_SAVE_TO_DATABASE )
public class SaveToDatabase implements Savable {

    @Autowired
    LocationDAOImpl locationDAOImpl;

    public SaveToDatabase() {

    }

    public void save(List<LocationPOJO> locationPOJOList) {

        for(LocationPOJO location : locationPOJOList){
            locationDAOImpl.save(location);
        }
        System.out.println(locationPOJOList.size() + " items inserted successfully.");
    }

    public void setLocationDAOImpl(LocationDAOImpl locationDAOImpl) {
        this.locationDAOImpl = locationDAOImpl;
    }
}


