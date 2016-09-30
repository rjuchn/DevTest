package interfaces;

import model.LocationPojo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Rafal on 2016-09-11.
 */
public interface Savable {
    void save (List<LocationPojo> locationPojoList);
}
