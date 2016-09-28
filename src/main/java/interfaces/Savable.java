package interfaces;

import model.LocationPOJO;

import java.util.List;

/**
 * Created by Rafal on 2016-09-11.
 */
public interface Savable {
    void save (List<LocationPOJO> locationPOJOList);
}
